public static void main(String[] args) {
    String string1 = "test1";
    String string2 = "test2";
    String string3 = "test3";
    String string4 = null;
    String string5 = "test5";

    StringBuilder stringBuilder = new StringBuilder();

    List<String> valueList = new ArrayList<>();
    valueList.add(string1);
    valueList.add(string2);
    valueList.add(string3);
    valueList.add(string4);
    valueList.add(string5);
    // etc.

    for (String value : valueList) {
        if (value != null) {
            stringBuilder.append(value);
        }
        else {
            value = ",";
            stringBuilder.append(value);
        }
    }
    System.out.println(stringBuilder);
}