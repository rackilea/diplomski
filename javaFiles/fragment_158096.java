public class test
{

private static JFrame frame = new JFrame();
private static JTabbedPane pane0 = new JTabbedPane();
private static JScrollPane pane1 = new JScrollPane();
private static JPanel pane2 = new JPanel();
//add the rest of your JPanels here

public static void main(String[] args)
{
     frame.setSize(400,400);
     //add all the other attributes here
     frame.add(pane0);
     pane0.add(pane1);
     pane1.add(pane2);
     //go ahead and add the rest of your panels here
     frame.pack();//resizes the frame so that its subcomponents fit well inside.
}
}//this last bracket is for the class itself.  Sorry i couldn't tab everything the right          //way.