{
    ...
    String someString = "CC23QQ21HD32";
    String regex = "((?<=[a-zA-Z])(?=[0-9]))|((?<=[0-9])(?=[a-zA-Z]))";
    System.out.println(Arrays.asList(someString.split(regex)));
    //outputs [CC, 23, QQ, 21, HD, 32]
    ...
}