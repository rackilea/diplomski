try {
  User user = user_target
      .request()
      .get(User.class);
  System.out.println(user);
} catch (ClientErrorException primary_exception) {
  try {
    ErrorResponse error_response = primary_exception.getResponse().readEntity(ErrorResponse.class);
    System.out.println(error_response);
  } catch (ClientErrorException secondary_exception) {
    System.err.println("Secondary Exception: " + secondary_exception.getMessage());
    throw new ThisAppException("Secondary Exception", secondary_exception);
  }
}