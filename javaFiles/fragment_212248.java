public class Storage {
  private String basedir;
  private List<Repository> repositories = new ArrayList<Repository>();
  ...
}

public class Repository {
  private String name;
  private String policy;
  private String layout;
  private String type;
  ...
}