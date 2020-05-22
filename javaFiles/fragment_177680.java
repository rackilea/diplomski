public class AbstractPamTest
{
  protected static final String user;
  protected static final String passwd;
  protected static final String badPasswd;

  static
  {
      user = System.getProperty("test.login");
      passwd = System.getProperty("test.passwd");
      if (user == null || passwd == null)
          throw new IllegalStateException("Please define test.login and"
              + " test.passwd before running tests");
      badPasswd = passwd + "x";
  }
}