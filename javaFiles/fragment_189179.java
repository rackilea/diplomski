class MyDrawing extends JPanel {

    ... //Constructor

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 500); //Changed from 1000 to 500
    }

    ... //paintComponent(...) 
        //If you change 1000 to 500, don't forget to change 960 to 460 too
}