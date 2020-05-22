JMenuBar myMenu = new MainMenu();
myMenu.setMain(this);//this is the Main class reference
setJMenuBar(myMenu);
//setMain inside MainMenu
public void setMain(Main main) {
    this.main = main;
}