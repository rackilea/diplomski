try
{
    String name = txtName.getText();
    String address = txtAddress.getText();
    double pay = Double.parseDouble(txtPay.getText());
    long ssid = Long.parseLong(txtSSID.getText());
    long number = Long.parseLong(txtNumber.getText());
    FinalProjectGroup1 ee = new FinalProjectGroup1(name, address, pay, ssid, number);
    FileWriter writer = new FileWriter(txtFolder.getText(), true);
    PrintWriter pw = new PrintWriter(writer);
    pw.println(ee.getName() + ", " + ee.getAddress() + ", " + ee.getNumber()
    + ", " + ee.getPay() + ", " + ee.getSSID());
    pw.close();
}

catch (Exception e)
{
    return;
}