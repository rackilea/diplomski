public static void main(String[] args) throws IOException {
    Bar bar1 = new Bar("first", "last", "m", "A");
    Bar bar2 = new Bar("first", "last", "m", "B");

    ObjectMapper mapper = new ObjectMapper();
    String json1 = mapper.writeValueAsString(bar1);
    String json2 = mapper.writeValueAsString(bar2);

    System.out.println(json1);
    System.out.println(json2);

}