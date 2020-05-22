String s = "ab cd 2 4 ef 12x";
StringBuffer result = new StringBuffer();
Matcher m = Pattern.compile("\\d+").matcher(s);
while (m.find()) {
    m.appendReplacement(result,
      String.valueOf((int)Math.pow(Double.parseDouble(m.group(0)), 2))); // Calculate
}
m.appendTail(result);
System.out.println(result.toString());