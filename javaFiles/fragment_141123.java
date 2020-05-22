@Data
class User {
    String name;

    @Setter(onMethod = @__(@Nested))
    Status status;
}