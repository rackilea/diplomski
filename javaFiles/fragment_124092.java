@FXML
private Label custmrName;
public static Label custmrNameDummy;
@FXML
private Label idLabel;
public static Label idLabelDummy;
static String customerName = null;
static String customerId = null;


public void initialize(URL location, ResourceBundle resources) {

    custmrNameDummy=custmrName;
    idLabelDummy=idLabel;


}


public static void setDataCustomer(String name, String cutmrId) {

    Item_bill.customerName = name;
    Item_bill.customerId = cutmrId;

    custmrNameDummy.setText(customerName);
    idLabelDummy.setText(String.valueOf(customerId));

}