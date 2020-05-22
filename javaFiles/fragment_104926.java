public class SpinnerSpecialValuesModel() extends JSpinner {
    // in this class you handle the fact that now, you have an
    // interval of values and a list of special values that are allowed.
    // here is what I did :
    @Override
    public Object getNextValue() {
        return incrValue(+1);
    }

    @Override
    public Object getPreviousValue() {
        return incrValue(-1);
    }

    private Object incrValue(int dir) {
        // NB : BigDecimal here because this is what I used,
        // but use what you want in your model
        BigDecimal result = null;
        BigDecimal numberBD = new BigDecimal(getNumber().toString());
        BigDecimal stepSizeBD = new BigDecimal(getStepSize().toString());
        BigDecimal dirBD = new BigDecimal(dir);
        BigDecimal nextValue = numberBD.add(stepSizeBD.multiply(dirBD));

        TreeSet<BigDecimal> currentAllowedValues = new TreeSet<BigDecimal>();
        currentAllowedValues.addAll(m_SpecialValues);
        if (getMaximum() != null) {
          currentAllowedValues.add((BigDecimal) getMaximum());
        }
        if (getMinimum() != null) {
          currentAllowedValues.add((BigDecimal) getMinimum());
        }
        if (isIncludedInBounds(nextValue)) {
          currentAllowedValues.add(nextValue);
        }

        if (dir > 0) {
          try {
            result = currentAllowedValues.higher(numberBD);
          }
          catch (NoSuchElementException e) {}
        }
        else if (dir < 0) {
          try {
            result = currentAllowedValues.lower(numberBD);
          }
          catch (NoSuchElementException e) {}
        }
        return result;
    }
}