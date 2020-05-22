private Controller controller = new Controller();

  @Override
  public void actionPerformed(ActionEvent e) {
    Customer c = new Customer();
    c.setOrgNumber(textFieldOrgNr.getText());
    c.setCompanyName(textFieldComanyName.getText());
    c.setBillingAdress(textFieldBillingAdress.getText());
    c.setCompanyContact(textFieldCompanyContact.getText());
    c.setEmail(textFieldEmail.getText());
    c.setAgreement(textFieldAgreement.getText());
    c.setPhoneNumber(textFieldPhoneNumber.getText());

    controller.addCustomer(c);

  }
});