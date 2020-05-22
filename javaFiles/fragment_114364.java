TabPane main = new TabPane();
main.getStyleClass().add("main-tab-pane");
Tab mainTab = new Tab("MainTab");
main.getTabs().add(mainTab);
TabPane secondTab = new TabPane(new Tab("SecondTab"));
secondTab.getStyleClass().add("inner-tab-pane");
mainTab.setContent(secondTab);