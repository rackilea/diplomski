ObservableList<Student> students = FXCollections.observableArrayList();
    students.addAll(one);

    TableView<Student> table = new TableView<>();
    TableColumn<Student,Integer> userId = new TableColumn<>("User Id");
    userId.setCellValueFactory(new PropertyValueFactory<>("id"));

    TableColumn<Student,String> groupName = new TableColumn<>("Group Name");
    groupName.setCellValueFactory(new PropertyValueFactory<>("groupName"));
    TableColumn<Student,String> name = new TableColumn<>("User Name");
    name.setCellValueFactory(new PropertyValueFactory<>("name"));

    TableColumn<Student,String> surname = new TableColumn<>("User Surname");
    surname.setCellValueFactory(new PropertyValueFactory<>("surname"));

    table.getColumns().addAll(userId,groupId,name,surname);
    table.setItems(students);