public Main {
  public static void main(String[] args) {
    CheckingAccount checkingAccount = new CheckingAccount();
    MyGui myGui = new MyGui();
    myGui.setCheckingAccount(checkingAccount);
    myGui.displaySomehow();
  }
}