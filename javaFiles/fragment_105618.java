@FXML TextField fName;
@FXML TextField lName;
@FXML DatePicker birthDay;
@FXML TextField address;
@FXML TextField city;
@FXML TextField telephoneNmbr;
@FXML TextField email;
@FXML Button closeBtn;
@FXML Button okBtn;

public void initialize(){

    fName.setOnAction(e -> lName.requestFocus());
    lName.setOnAction(e -> birthDay.requestFocus());
    birthDay.setOnAction(e -> address.requestFocus());

    // etc...

    okBtn.setOnAction(e -> {
        // whatever you need to do when OK is pressed...
    });
}