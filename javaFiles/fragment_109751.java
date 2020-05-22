public void btnLeftPanelMainmenuOnClickAction(ActionEvent e) {
        AppWindow.borderPane.setCenter(AppWindow.mainMenu.getCenterMainUI());
    }

    public void btnLeftPanelDbOnClickAction(ActionEvent e) {
        AppWindow.borderPane.setCenter(AppWindow.dbMenu.getCenterDbUI());
    }

    public void btnLeftPanelConfigurationOnClickAction(ActionEvent e) {
        AppWindow.borderPane.setCenter(AppWindow.configMenu.getCenterConfigurationUI());
    }