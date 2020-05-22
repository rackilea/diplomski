FXMLLoader listLoader = new FXMLLoader(getClass().getResource("lista.fxml"));
FXMLLoader textareaLoader = new FXMLLoader(getClass().getResource("textarea.fxml"));
FXMLLoader fieldLoader = new FXMLLoader(getClass().getResource("textfield.fxml"));

AnchorPane root = new AnchorPane(listLoader.load(), textareaLoader.load(), fieldLoader.load());

ListController listController = listLoader.getController();
TextAreaController textareaController = textareaLoader.getController();
TextFieldController fieldController = fieldLoader.getController();

DataModel model = new DataModel();
listController.initModel(model);
textareaController.initModel(model);

...