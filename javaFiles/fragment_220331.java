@interface PrePersist {}

public class Registry {

    @NotNull
    String userName;

    @NotNull(groups = PrePersist.class)
    Date createdAt;
}