boolean first = true ; 
for(String settingName: settingsList){
    Label settingLabel = new Label(settingName);
    settingLabel.getStyleClass().add("setting-label");
    if (first) {
        settingLabel.getStyleClass().add("first");
    }
    first = false ;
    root.getChildren().add(settingLabel);
}