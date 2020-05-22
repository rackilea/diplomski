public class MyActiveProfilesResolver  implements ActiveProfilesResolver{
  @Override
  public String[] resolve(Class<?> testClass) {
      Map<String, String> env =  System.getenv();
      String profile;
      if (env.hasKey("TEST_ENV")) {
          profile = env.get("TEST_ENV");
      } else {
          profile = "local-test"; // it is more convenient to to have this as default to be used in dev env and override it on test env
      }
      return new String[]{profile};
  }
}