private Command myCommand = new Command("");
Form f = new Form("Test form");
Toolbar t = new Toolbar();
f.setToolbar(t);

Command back = new Command("Back") {

    @Override
    public void actionPerformed(ActionEvent evt) {
       //Do stuff
    }
};
back.putClientProperty("uiid", "BackCommand");
f.setBackCommand(back);
t.addCommandToLeftBar(back);

myCommand = new Command(YourProgressImage) {

    @Override
    public void actionPerformed(ActionEvent evt) {
        //To show the progress when some actions are being performed 
        showTitleProgress(t);
        //When you're done, discard the progress and restore your command
        hideTitleProgress(t, myCommand);
    }
}
myCommand.putClientProperty("TitleCommand", true);
t.addCommandToRightBar(myCommand);
f.show();