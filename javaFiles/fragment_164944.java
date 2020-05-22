public static void main(String[] args) {

    String input = "=?utf-8?B?UmVtaW5kZXI=?=";
    String input2 = "irege";

    String regex = "=\\?utf\\-8\\?B\\?.*=\\?=";

    System.out.println(input.matches(regex));
    System.out.println(input2.matches(regex));

}