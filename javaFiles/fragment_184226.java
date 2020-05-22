public class FileWriterUsingJFrame extends JFrame implements ActionListener
{
    //now your class is a JFrame having all methods from including  setVisible()
    //as you did on Multiplepannel

    //remove line 
    //JFrame window = new JFrame("Hotel Ibis");

    //add line in constructor `FileWriterUsingJFrame()`
    setTitle("Hotel Ibis");

    //use (this) instead of (window) : (this) is the current object 
    //since you wanted  FileWriterUsingJFrame to be display and not a nested class from

    //window.add(userNameLabel); should be
    this.add(userNameLabel);
    // work also even without this, since you refer your current obj
    //add(userNameLabel);
}