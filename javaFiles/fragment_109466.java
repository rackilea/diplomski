String TillNo = "S59997-RSS01";
System.out.println(TillNo.substring(TillNo.length() - 2));
Pattern pattern = Pattern.compile("S[\\d]{5}-RSS([\\d]{2})");
Matcher matcher = pattern.matcher(TillNo);
if (matcher.find()) {
    System.out.println(matcher.group(1));
}