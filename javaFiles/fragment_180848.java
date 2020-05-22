Model model = new Model(); // or just reference to existing model...

FXMLLoader loader = new FXMLLoader(getClass().getResource("View.fxml"));
loader.setController(new Controller(model));
Parent root = loader.load();
// ...

model.setPosition("Left"); // will update text in view