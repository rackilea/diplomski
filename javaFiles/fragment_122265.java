// GuiDMenuBar mbr;
GuiDMenuBar mbr = new GuiDMenuBar(); // create instance and assign

public void runGUI()
{
    // ....

    // myMainWindow.setJMenuBar(mbr.GuiDMenuBar());
    myMainWindow.setJMenuBar(mbr); // use instance

    myMainWindow.setVisible(true);
}