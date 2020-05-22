...
    private String getFormattedNumberString(Cell cell, ConditionalFormattingEvaluator cfEvaluator) {
        if (cell == null) {
            return null;
        }
        Format numberFormat = getFormat(cell, cfEvaluator);

        double d = cell.getNumericCellValue();
        java.math.BigDecimal bd = new java.math.BigDecimal(d);
        d = bd.round(new java.math.MathContext(15)).doubleValue();

        if (numberFormat == null) {
            return String.valueOf(d);
        }
        String formatted = numberFormat.format(Double.valueOf(d));
        return formatted.replaceFirst("E(\\d)", "E+$1"); // to match Excel's E-notation
    }
...