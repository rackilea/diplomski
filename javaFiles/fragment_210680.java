public class Email {
  private Subject      subject;
  private Body         body;
  private Recipient    recipient;

  public Email() {
    this.subject = new Subject();
    this.body = new Body();
    this.recipient = new Recipient();
  }

  public void setText(String text){
    this.body.text = text;
  }
  //more getters & setters...

  private class Subject {
    public String text;
  }
  private class Body {
    public String text;
    public String format;
  }
  private class Recipient {
    public String address;
  }
}