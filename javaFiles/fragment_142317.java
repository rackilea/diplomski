public static void main(String[] args) {
    Person p = new Person();
    p.setName("Tester");
    ToStringStyle style = new TestStyle();

    System.out.println("toString = " + ToStringBuilder.reflectionToString(p, style));

}