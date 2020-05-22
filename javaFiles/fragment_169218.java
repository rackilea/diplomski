public NewJFrame() {                            // Constructor
    initComponents();
    this.setExtendedState( getExtendedState() | JFrame.MAXIMIZED_VERT | Frame.MAXIMIZED_HORIZ);
    // height and width still prints the original values 
    System.out.println(this.getSize().height + " " + this.getSize().width); 
}

....

public static void main(String args[]) {        // main
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            NewJFrame foo = new NewJFrame();
            foo.setVisible(true);
            // after setVisible(true) actual maximized values
            System.out.println(foo.getSize().height + " " + foo.getSize().width);
        }
    });
}