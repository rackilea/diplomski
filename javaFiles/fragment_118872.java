try {
    String maxString = formatter.valueToString(model.getMinimum());
    String minString = formatter.valueToString(model.getMaximum());
    ftf.setColumns(Math.max(maxString.length(),
                            minString.length()));
}
catch (ParseException e) {
    // TBD should throw a chained error here
}