@Data
class User {
    String name;

    @Setter(onMethod = @__(@Nested("status")))
    Status status;
}