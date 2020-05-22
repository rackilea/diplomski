// View definitions:
  class Views {
            static class Public { }
            static class Internal extends Public { }
  }

  public class User {
            // Name is public
            @JsonView(Views.Public.class) String name;
            // Hash password only for internal usage
            @JsonView(Views.Internal.class) String hashPassword;
  }