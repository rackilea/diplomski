public void stuff(){
    JFileChooser chooser = null;
    LookAndFeel previousLF = UIManager.getLookAndFeel();
    try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        chooser = new JFileChooser();
        UIManager.setLookAndFeel(previousLF);
    } catch (IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException e) {}
    //Add whatever other settings you want to the method
    chooser.showOpenDialog(frame);
}