public class DecisionInput {
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @NotEmpty
    private String url;
    @NotEmpty
    private String imageUrl;
    private Decision parentDecision;
    private Tenant tenant;
    @NotNull
    private User user;

    // Constructors, getters, setters, ...
}