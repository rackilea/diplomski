SideBar sideBar = new SideBar();
ListenForButton listenForButton = new ListenForButton();

public ActionController() {
}

public void clickOnButtons() {
    sideBar.getButton_pencil().addActionListener(listenForButton);

}