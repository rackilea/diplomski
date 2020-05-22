public static void main(String[] args) throws IOException {
    ObjectMapper om = new ObjectMapper();
    List<Common> list = new JacksonList<Common>();
    list.add(new A());
    list.add(new B());
    om.addMixInAnnotations(A.class, AMixIn.class);
    om.addMixInAnnotations(B.class, BMixIn.class);
    System.out.println(om.writeValueAsString(list));
    System.out.println(om.writeValueAsString(new A()));
}