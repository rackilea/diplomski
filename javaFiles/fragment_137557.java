public static void main(String[] args) {
  String input[] = ("typeA:code1," +
                "typeA:code2," +
                "typeA:code3," +
                "typeB:code4," +
                "typeB:code5," +
                "typeB:code6," +
                "typeC:code7").split(",");

  Map<String, List<String>> result = Stream.of(input)
                    .collect(groupingBy(A::getType, mapping(A::getValue, toList())));
  System.out.println(result);
}

public static String getType(String code) {
  return code.split(":")[0];
}
public static String getValue(String code) {
  return code.split(":")[1];
}