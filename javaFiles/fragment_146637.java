public class BasicAccount {
  protected String email;

  @Length(min = 1, max = 50,
          message = "'Name' must be between 1 and 50 characters in length.")
  private String name;
}

public class EmailValidatedAccount extends BasicAccount {
  @Length(min = 1, max = 100, 
          message = "'Email' must be between 1 and 100 characters in length.")
  @NotNull(message = "'Email' must not be empty.")
  @Override
  public String getEmail() {
    return email;
  }
}

public class AuthorizedUser extends BasicAccount {
  @Length(min = 1, max = 40,
          message = "'Field' must be between 1 and 50 characters in length.")
  private String field;
}