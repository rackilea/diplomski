public static void main(String[] args) throws JsonProcessingException {

    ObjectMapper myMapper=  new ObjectMapper();
    ObjectMapper dwMapper = Jackson.newObjectMapper();
    System.out.println(myMapper.writeValueAsString(new X()));
    System.out.println(dwMapper.writeValueAsString(new X()));
}

public static class X { 
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-dd HH:mm:ss")
    DateTime now = DateTime.now();
}