String valueStr = value.toString();
if (valueStr != null) {
    String str[] = valueStr.split("\t");
    if (str[] != null && str.size > 3) {
        category.set(str[3]);
        context.write(category, one);
    }
}