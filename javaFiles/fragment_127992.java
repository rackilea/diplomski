public static String getParameterValue(String input, String parameter) {
    return input.replaceAll("(.*("+parameter+"=(\\w+)).*)|.*", "$3"));
}

public static void main(String[] args) {
    String input1 = "foo=bar&app_id=D4KnHBzGYyJtbM8lVfYX&x=y";
    String input2 = "foo=bar&XXXXXX=D4KnHBzGYyJtbM8lVfYX&x=y";

    System.out.println("app_id1:" + getParameterValue(input1, "app_id"));
    System.out.println("app_id2:" + getParameterValue(input2, "app_id"));
}