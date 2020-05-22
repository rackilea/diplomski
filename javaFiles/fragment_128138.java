public class HelloWorld extends ActionSupport {
  @Action("/different/url")
  public String execute() {
    return SUCCESS;
  }
}