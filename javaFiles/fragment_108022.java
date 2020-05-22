public static void main(String[] args) throws IOException {
        String s = "{}";
        ObjectMapper mapper = new ObjectMapper();
        Student ss = mapper.readValue(s, Student.class);
        System.out.println(ss.getX());
    }