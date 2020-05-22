ListenForButton listenForButton = new ListenForButton();

public ActionController() {
}

public void clickOnButtons(SideBar sideBar) {
    sideBar.getButton_pencil().addActionListener(listenForButton);

}