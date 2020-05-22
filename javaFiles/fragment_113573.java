public static void main(String[] args) throws Exception {

    GivenClass o1 = new GivenClass("Mike", "London", 28);

    Map<String, Object> serialized = o1.serialize();

    GivenClass o2 = new GivenClass(serialized);
    System.out.println(o2.toString());
}