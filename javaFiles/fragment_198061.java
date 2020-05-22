public static void main(String[] args) {
    String patternStr = "[0-9.-]*e[0-9.-]*";
    String word = "m -263.61653,-131.25745 c -7.5e-4,-1.04175 0.71025,-1.90875 1.67025,-2.16526";
    Pattern pattern = Pattern.compile(patternStr);
    Matcher matcher = pattern.matcher(word);
    if (matcher.find()) {
        Double d = Double.valueOf(matcher.group());
        System.out.println(word.replaceAll(patternStr, BigDecimal.valueOf(d).toPlainString()));
    }

}