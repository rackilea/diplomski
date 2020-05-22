public class ddd
{

    JFrame frame = new JFrame();
    JPanel leftPane = new JPanel();
    JPanel rightPane = new JPanel();
    JTextArea textArea = new JTextArea();
    JButton button = new JButton("LOL");
    JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);


    public ddd()
    {
    /** __COMPONENT OBJECTS__ **/


    splitPane.setLeftComponent(leftPane);
    splitPane.setRightComponent(rightPane);
    splitPane.setLayout(null);
//  splitPane.setSize(frame.getWidth(), frame.getHeight() - menuBar.getHeight());
    splitPane.setVisible(true);
//  splitPane.setLocation(0, menuBar.getHeight());

    /** __RIGHTPANE-PROPS__ **/
    rightPane.add(textArea);
    rightPane.setSize(500, 100);
    rightPane.setVisible(true);


    /** __LEFTPANE-PROPS__ **/
    leftPane.add(button);
    leftPane.setSize(100, 100);
    leftPane.setVisible(true);

    /** __FRAME-PROPS__ **/
    frame.add(splitPane);
    frame.setLayout(new GridLayout());
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setSize(500, 400);
    frame.setVisible(true);
    }

    public static void main(String[] args)
    {
    new ddd();
    }
}