interface KotlinUserRepository extends Repository {

  User findById(String username);

  User search(String username);

  @Metadata(…)
  public static final class DefaultImpls {

    public static User search(KotlinUserRepository $this, String username) {
      Intrinsics.checkParameterIsNotNull(username, "username");
      return $this.findById(username);
    }
  }
}