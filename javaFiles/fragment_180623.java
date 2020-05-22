class Views {
    static class Public {}
    static class ExtendedPublic extends PublicView {}
    ...
}

public class Thing {
    @JsonView(Views.Public.class) Integer id;
    @JsonView(Views.ExtendPublic.class) String name;
}