public class ReadFile {
  public static void main(String[] args) throws Exception {
    FileInputStream file = new FileInputStream("user.data");
    User user = User.parseDelimitedFrom(file);
    System.out.println(user);
    User user2 = User.parseDelimitedFrom(file);
    System.out.println(user2);
  }
}