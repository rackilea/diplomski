private  static String user;
  private  static String passwd;
  private  static String badPasswd;

  static
  {
      user = System.getProperty("test.login");
      passwd = System.getProperty("test.passwd");
      if (user == null || passwd == null)
          throw new IllegalStateException("Please define test.login and"
              + " test.passwd before running tests");
      badPasswd = passwd + "x";
  }

  public static String getUser()
  {
    return user;
  }

  public static void setUser(String pUser)
  {
    user = pUser;
  }

  public static String getPasswd()
  {
    return passwd;
  }

  public static void setPasswd(String pPasswd)
  {
    passwd = pPasswd;
  }