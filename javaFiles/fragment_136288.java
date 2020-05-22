private List<String> getPrice(String caption) {
    String pricePattern = "(?i)(\\d[\\d,]*)\\s*(?:[$€¥¢]|dollar|Euro)";
    List<String> lstPrice = new ArrayList<>();
    Pattern rPrice = Pattern.compile(pricePattern);
    Matcher mPrice = rPrice.matcher(caption);
    while (mPrice.find()) {
        lstPrice.add(mPrice.group(1));
    }
    return lstPrice;
}