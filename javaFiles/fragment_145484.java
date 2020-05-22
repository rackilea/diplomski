if (e.getSource() == create)  {
     try {
         creatNewAccount(name3.getText());
     } catch (IOException ie) {
         ie.printStackTrace();
         // handle error
     }
     BALANCE = Double.parseDouble(name2.getText());
}