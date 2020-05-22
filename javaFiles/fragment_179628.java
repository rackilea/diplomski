class Pojo {

    @JsonDeserialize(using = LocalDateJsonDeserializer.class)
    private LocalDate date;
    private String name;
    private Message message;

    // getters, setters
}

class Message {

    private String product;
    private int price;

    // getters, setters
}