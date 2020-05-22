public class Foo {

    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    private LocalDate date;

    // Getters and setters
}