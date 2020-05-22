filters = new Vector<Filter>();
while ((tmpStr = Utils.getOption("F", options)).length() != 0) {
    options2 = Utils.splitOptions(tmpStr);
    filter = options2[0];
    options2[0] = "";
    filters.add((Filter) Utils.forName(Filter.class, filter, options2));
}