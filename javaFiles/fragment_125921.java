public class Demo extends Application {

    private final ObservableList<Employee> data =
            FXCollections.observableArrayList(
            new Employee("Azamat", 2200.15),
            new Employee("Veli", 1400.0),
            new Employee("Nurbek", 900.5));

    @Override
    public void start(Stage primaryStage) {

        ComboBox<Employee> combobox = new ComboBox<>(data);
        combobox.getSelectionModel().selectFirst(); // Select first as default
        combobox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Employee>() {

            @Override
            public void changed(ObservableValue<? extends Employee> arg0, Employee arg1, Employee arg2) {
                if (arg2 != null) {
                    System.out.println("Selected employee: " + arg2.getName());
                }
            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(combobox);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    public static class Employee {
        private String name;
        private Double salary;

        @Override
        public String toString() {
            return name + " (sal:" + salary + ")";
        }

        public Employee(String name, Double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}