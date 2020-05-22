String s = "data.orderType.`order.created.time`";
String regex = "`([^`]*)`|[^.`]+";
List<String> result = new ArrayList<>();
Matcher m = Pattern.compile(regex).matcher(s);
while (m.find()) {
   if (m.group(1) != null) {
       result.add(m.group(1));
   } else {
       result.add(m.group());
   }
}
System.out.println(result);
// => [data, orderType, order.created.time]