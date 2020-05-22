public class TheFrame {

    private JFrame theframe;
    private String title = "Test";
    private int width = 1024;
    private int height = 576;

    public TheFrame(){
        theframe = new JFrame(title);
        theframe.setSize(width, height);
        theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theframe.setLocationRelativeTo(null);
        theframe.setVisible(true);

        //call the canvas
        TheCanvas thecanvas = new TheCanvas(width, height);

        //!
        theframe.add(thecanvas.getTheCanvas());
    }    
}