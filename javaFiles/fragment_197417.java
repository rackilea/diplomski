public static void main(String[] args) {
    MainView mainView = new MainView();
    ViewController viewController = new ViewController(mainView);
    SettingsView settingsView = new SettingsView(viewController);
    settingsView.simComboChange(0);
    settingsView.simComboChange(1);
}