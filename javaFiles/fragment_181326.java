class DrawPanel extends JPanel {

    private List<MyShape> shapes;//stores all shapes the user draws
    //...

    public DrawPanel(JLabel statusLabel) {
        //...
        shapes = new ArrayList<>(100);