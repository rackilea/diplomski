@Override
public void initialize(URL location, ResourceBundle resources) {
//  choiceBoxInit();
//  observeChoiceBox();
//  removeUser();
}

public void choiceBoxInit(){
    System.out.println(this.mainControl.getModelLogic());
//  UsersChoiceBox.setItems(this.mainControl.getModelLogic().getUserList());
}

// ...

public void setMainControl(MainPanelController mainPanel){
    mainControl=mainPanel;
    choiceBoxInit();
}