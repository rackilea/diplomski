BigDecimal value = new BigDecimal("327.81");
    BigDecimal[] percents = new BigDecimal[] {
            new BigDecimal(30),
            new BigDecimal(20),
            new BigDecimal(30),
            new BigDecimal(20) };
    BigDecimal accError = BigDecimal.ZERO;
    BigDecimal maxError = new BigDecimal("0.005");
    BigDecimal adjust   = new BigDecimal("0.01");
    BigDecimal hundred  = new BigDecimal("100");
    BigDecimal total    = BigDecimal.ZERO;
    for (BigDecimal pct : percents)
    {
        BigDecimal unrounded    = value.multiply(pct).divide(hundred); 
        BigDecimal rounded      = unrounded.setScale(2,RoundingMode.HALF_EVEN);
        BigDecimal error        = rounded.subtract(unrounded);
        BigDecimal correction   = BigDecimal.ZERO;
        accError = accError.add(error);
        if (accError.abs().compareTo(maxError) > 0)
            correction = accError.signum() > 0 ? adjust.negate() : adjust;
        rounded = rounded.add(correction);
        accError = accError.add(correction);
        System.out.println(unrounded.toString() + " " + rounded.toString() + " " + error.toString() + " " + accError.toString() + " " + correction.toString());

        total = total.add(rounded);
    }
    System.out.println("Total is " + total.toString());
}