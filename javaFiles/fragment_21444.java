// Your node/token class
public class Node {
  private String token;
  public Node(String token) {
    this.token = token;
  }
  public String getToken() {
    return token;
  }
  public void print() {
    System.out.println(token);
  }
}