public class FrontEndController implements Initializable {

    @FXML private TableView<GameOfThronesCharacter> table;
    @FXML private TableColumn<GameOfThronesCharacter,String> nameColumn;
    @FXML private TableColumn<GameOfThronesCharacter,String> allegianceColumn;
    @FXML private TableColumn<GameOfThronesCharacter,String> positionColumn;
    @FXML private TableColumn<GameOfThronesCharacter,Double> salaryColumn;



    private ObservableList<GameOfThronesCharacter> getCharacters(){
        ObservableList<GameOfThronesCharacter> characters = FXCollections.observableArrayList();
        characters.add(new GameOfThronesCharacter("Cersei","Lannister","Queen Regent",100000));
        characters.add(new GameOfThronesCharacter("Jaime","Lannister","King Slayer",80000));
        characters.add(new GameOfThronesCharacter("Tyrion","Lannister","Queen's Hand",60000));

        return characters;
    }



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //nameColumn
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //allegianceColumn
        allegianceColumn.setCellValueFactory(new PropertyValueFactory<>("allegiance"));

        //positionColumn
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));

        //salaryColumn
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));

        //table = new TableView<>();
        table.setItems(getCharacters());

    }
}