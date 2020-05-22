public class MyGui {
  private CheckingAccount checkingAccount;
  private JButton myButton = new new JButton("My Button");

  public MyGui() {
    myButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent evt) {
        if (checkingAccount == null) {
          return;
        }
        checkingAccount.someMethod();
      }
    });
  }

  public void setCheckingAccount(CheckingAccount checkingAccount) {
    this.checkingAccount = checkingAccount;
  }

}