public class User {
    @VersioningProperties({
        @Property(version = "1.5", value = "fname"),
        @Property(version = "1.6", value = "firstName")
    })
    private String firstName;

    // constructors, getters and setters
}