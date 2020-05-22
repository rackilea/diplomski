class MainForm extends Form {

  private Label welcomeLbl;

  public MainForm () {
    //here you dont have the username
    //but running it in the background creates all the components, so...
    welcomeLbl = new Label();
  }

  public void provideParameters (String name, String pw) {
    //...they are ready to use here!
    this.welcomeLbl.setText("Welcome " + name);
  }
}