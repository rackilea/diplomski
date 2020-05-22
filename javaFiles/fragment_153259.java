public class TestTreeView extends JFrame {

    JTextField jtf = new JTextField (30);
    JButton jb = new JButton ("go!");

    public TestTreeView () {
        setSize (900, 600); // a
        Container cp = getContentPane (); // b
        JPanel jp = new JPanel ();
        jp.setLayout (new BorderLayout());
        cp.add (jp);
        jp.setBorder (BorderFactory.createEtchedBorder ()); // c
        JPanel tp = new JPanel ();
        tp.setLayout (new FlowLayout ());
        tp.add (jtf);
        jtf.setText ("1+2*3/4%5");
        jtf.setFont ((jtf.getFont()).deriveFont (24.0f)); // I like big fonts, maybe need stronger glasses :) 
        tp.add (jb);
        jp.add (tp, BorderLayout.NORTH);
        actions (jp); // see below
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setVisible (true);
    }

    public void actions (JPanel jp) {
        jb.addActionListener (ae -> {
            String s = jtf.getText ();
            System.out.println (s);
            if (s.length () > 1) {
                //create parse trees from input in JTextField
                Parser p = new Parser (s); // redefined, see below 
                ExpTree myTree;

                try {
                    myTree = p.parseLine ();
                    System.out.println (myTree.toPostfix(myTree));

                    TreeView view = new TreeView (myTree);
                    jp.add (view, BorderLayout.CENTER);
                    // view.repaint();
                    // jp.invalidate ();
                    jp.revalidate (); // c
                }
                catch (ParseException e) {
                    System.out.println ("Invalid Expression: Ensure it ends with a semicolon");
                }
            }
        });
    }

    public static void main (String[] args) {
        TestTreeView test = new TestTreeView ();
    }
}