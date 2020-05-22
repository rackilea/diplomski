/*
 * Returns last year, current year and next year as List<SelectItem>
 * For use with comboBox selection values
 */
public List<SelectItem> getYears() {
    int thisYear = Calendar.getInstance().get(Calendar.YEAR);
    List<SelectItem> years = new ArrayList<SelectItem>();
        years.add((new SelectItem(new Double(thisYear - 1), new Integer(thisYear - 1).toString())));
        years.add(new SelectItem(new Double(thisYear), new Integer(thisYear).toString()));
        years.add(new SelectItem(new Double(thisYear + 1), new Integer(thisYear + 1).toString()));

    }
    return years;
}