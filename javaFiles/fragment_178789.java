public void writeListToJsonArray() throws IOException {  
    final List<Event> list = new ArrayList<Event>(2);
    list.add(new Event("a1","a2"));
    list.add(new Event("b1","b2"));

    final ByteArrayOutputStream out = new ByteArrayOutputStream();
    final ObjectMapper mapper = new ObjectMapper();

    mapper.writeValue(out, list);

    final byte[] data = out.toByteArray();
    System.out.println(new String(data));
}