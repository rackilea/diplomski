class Button2 extends JButton {
    MainPanel someObj2 = new MainPanel();//you create an instance of MainPanel which isnt even showing and than do changes on that, this way you will never see any of the changes

    Button2() {
    }
}