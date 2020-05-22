private Command saveCMD = new Command("");

...

final Command afterSaveCmd = new Command("SAVED") {
    @Override
    public void actionPerformed(ActionEvent evt) {                                
        //What saved command should do, if any.
    };
};

saveCMD = new Command("SAVE") {
    @Override
    public void actionPerformed(ActionEvent evt) {                                
        Display.getInstance().vibrate(100);
        doSavingMethod();
        saveCMD = new Command("SAVED");
        //OR 
        saveCmd = afterSaveCmd;
        saveCMD.putClientProperty("uiid", "SaveCommand");
        form.removeCommand(saveCMD);
        toolbar.addCommandToRightBar(saveCMD);
        //form.revalidate();
    };
};
saveCMD.putClientProperty("uiid", "SaveCommand");
toolbar.addCommandToRightBar(saveCMD);