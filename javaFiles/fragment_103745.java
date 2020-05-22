public class Controller {
    @FXML
    private TableColumn<Order, Integer> ageColumn ;

    public void initialize() {
        ageColumn.setCellValueFactory( data -> {
             Order order = data.getValue();
             Person person = order.getPerson();
             Integer age = person.getAge();
             return new ReadOnlyIntegerWrapper(age);
        });

        //...
   }
 );