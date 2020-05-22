//constructor
public B(formA a)
{
    this.mainForm = a;

    //...
}


public void setDataToAAndExit()
{
    this.mainForm.getDataFromB(this.dataToA);
    //re-show main window
    this.mainForm.setVisible(true);
    //close this window
    this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
}