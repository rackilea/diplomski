@Override
public void start(Stage primaryStage) {

    PropertySheet propertySheet = new PropertySheet();

    propertySheet.setPropertyEditorFactory(new CustomPropertyEditorFactory());

    Musicians address = new Musicians();

    // 1: set initial selected values:
    address.getPersons().add(new Person("Paul", "McCartney"));

    // 2: listen to changes in selection:
    address.personsProperty().addListener((ors, ov, nv) -> {
        System.out.println("Selected persons:");
        nv.forEach(System.out::println);
    });

    propertySheet.getItems().setAll(BeanPropertyUtils.getProperties(address));

    Scene scene = new Scene(propertySheet, 500, 500);
    primaryStage.setScene(scene);
    primaryStage.show();
}