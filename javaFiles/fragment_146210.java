public class MapGrid extends JPanel implements Common, MouseListener{
    //...

    Selector s = new Selector();  // ******* HERE **********

    // ...

    public void mousePressed(MouseEvent evt) {
        // ....

            else{
                brick[index].setChoice(s.display);
                cell[index]=s.display;
            }
        // ....
    }

    //...
}