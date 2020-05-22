public class TableViewOnScroll extends Application {

    private ObservableList<Person> peopleToAdd;

    private int start = 0;
    private int step = 50;

    @Override
    public void start(Stage primaryStage) throws Exception {

        TableView<Person> tableView = new TableView<Person>();

        ObservableList<Person> displayedPeople = getInitialPeople();
        peopleToAdd = getPeopleToAdd();

        TableColumn<Person, String> firstNameCol = new TableColumn<Person, String>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory("firstName"));
        TableColumn<Person,String> lastNameCol = new TableColumn<Person,String>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory("lastName"));

        tableView.getColumns().setAll(firstNameCol, lastNameCol);
        tableView.setItems(displayedPeople);

        primaryStage.setScene(new Scene(tableView, 600, 400));
        primaryStage.show();

        // Be sure to put the listener after the stage is shown or the application will throw a NullPointerException
        ScrollBar tableViewScrollBar = getTableViewScrollBar(tableView);
        tableViewScrollBar.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double position = newValue.doubleValue();
                ScrollBar scrollbar = getTableViewScrollBar(tableView);
                if(position == scrollbar.getMax()) {
                    if(step <= peopleToAdd.size()) {
                        displayedPeople.addAll(peopleToAdd.subList(start, step));
                        start = step;
                        step += 50;
                        tableView.scrollTo(start);
                    }
                }
            }
        });
    }

    public ObservableList<Person> getPeopleToAdd() {
        ObservableList<Person> people = FXCollections.observableArrayList();
        for(int i = 0; i < 500; i++) {
            people.add(new Person("Patty", "Johnson"));
        }

        return people;
    }

    public ObservableList<Person> getInitialPeople() {
        ObservableList<Person> people = FXCollections.observableArrayList();
        for(int i = 0; i < 50; i++) {
            people.add(new Person("John", "Smith"));
        }

        return people;
    }

    private ScrollBar getTableViewScrollBar(TableView<?> listView) {
        ScrollBar scrollbar = null;
        for (Node node : listView.lookupAll(".scroll-bar")) {
            if (node instanceof ScrollBar) {
                ScrollBar bar = (ScrollBar) node;
                if (bar.getOrientation().equals(Orientation.VERTICAL)) {
                    scrollbar = bar;
                }
            }
        }
        return scrollbar;
    }

    public static void main(String[] args) {
        launch(args);
    }
}