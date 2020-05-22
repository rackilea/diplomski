// sample.Controller
    @FXML
    private TableView<Student> tableView;

    @FXML
    private TableColumn<Student, String> nameCol;

    @FXML
    private TableColumn<Student, String> SurCol;


    @FXML
    public final void initialize() {

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        SurCol.setCellValueFactory(new PropertyValueFactory<>("surname"));
        tableView.setItems(getStudentList());

    }

    public ObservableList<Student> getStudentList() {
        ObservableList<Student> data =  
                     FXCollections.observableArrayList();
        for (int i = 0; i < 10; i++) {
            data.add(new Student(i, String.format("%sth name", i), 
            String.format("%sth Surname", i)   ));

        }
        return data;
    }