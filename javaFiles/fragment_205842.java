String text = " value 1 = #value1 and value 2 = #value2 ";
int[] intArray = new int[] { 4, 5 };
Pattern p = Pattern.compile("#value(\\d+)");
Matcher m = p.matcher(text);
StringBuffer result = new StringBuffer();
while (m.find()) {
    m.appendReplacement(result, String.valueOf(intArray[Integer.parseInt(m.group(1)) - 1]));
}
m.appendTail(result);
System.out.println(result.toString());