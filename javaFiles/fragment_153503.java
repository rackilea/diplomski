public class TestPanel extends JPanel{
    TestPanel(){
        super();
        System.out.println("Running in constructor.  ");
        JLabel myLabel = new JLabel("Hello World");
        add(myLabel);
        System.out.println("Still running in constructor.  ");
    }
}