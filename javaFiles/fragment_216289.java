public class Forest{//open forest

    public static void main(String[] args) {
        Frame frame = new Frame("Hello World");

        GLCapabilities glcapabilities = new GLCapabilities();
        GLCanvas glcanvas = new GLCanvas(glcapabilities);
        frame.add(glcanvas);

        frame.setSize(300, 300);
        frame.setBackground(Color.WHITE);

        frame.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });//close forest
        frame.setVisible(true);
    }
}