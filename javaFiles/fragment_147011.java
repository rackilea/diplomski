public Constructor() {
    initComponents();
    retriveNameData();
}



private void createCustomer() {
    //getting text from the fields
    int id = Integer.parseInt(txfId.getText());
    String name = String.valueOf(txfName.getText());
    String lastName = String.valueOf(txfSurname.getText());
    String buisness = String.valueOf(txfBuisness.getText());
    String street = String.valueOf(txfStreet.getText());
    String unit = String.valueOf(txfUnit.getText());
    String city = String.valueOf(txfCity.getText());
    String province = String.valueOf(txfProvince.getText());
    String postal = String.valueOf(txfPostal.getText());
    String email = String.valueOf(txfEmail.getText());
    String phoneNumber = String.valueOf(txfPhone.getText());

    Address address = new Address(unit, street, city, province, postal);
    Customer customers = new Customer(id, name, lastName,
            phoneNumber, email, address, buisness);

    File file = new File("customer.txt");
    //appending to a file
    try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {

        writer.print("id: " + id);
        writer.print(" , First name: " + name);
        writer.print(" , Last name: " + lastName);
        writer.print(" , Phone Number: " + phoneNumber);
        writer.print(" , Email: " + email);
        writer.print(address);
        writer.println(" , Buisness: " + buisness);
    } catch (IOException ex) {
        System.out.println(ex.toString());
    }

    retriveNameData();

//chooseExisting.getItems().add(name);
//hooseExisting.setId(name);
//chooseExisting.setValue(name);
//chooseExisting.setOnAction(e -> {
//        });
//clearing the text after it saved

    txfId.setText("");
    txfName.setText("");
    txfSurname.setText("");
    txfBuisness.setText("");
    txfStreet.setText("");
    txfUnit.setText("");
    txfCity.setText("");
    txfProvince.setText("");
    txfPostal.setText("");
    txfEmail.setText("");
    txfPhone.setText("");

}

// this method will retrieve the Name data from the text file.
private void retriveNameData(){
    String line;
    try{
        InputStream fis = new FileInputStream("customer.txt");
        InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
        BufferedReader br = new BufferedReader(isr);

        while ((line = br.readLine()) != null) {
            String[] words = line.split(" ");
            String item=words[5]+" "+words[9];
            chooseExisting.addItem(item);
        }
    }catch(Exception e){

    }
}