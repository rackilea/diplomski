class Pojo {

    @JsonDeserialize(using = LocalDateTimeJsonDeserializer.class)
    private LocalDateTime time;
    private String name;
    private Message message;

    // getters, setters, toString
}