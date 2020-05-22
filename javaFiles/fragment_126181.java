public class ButtonAction extends AbstractAction {

    private int row, col;

    protected ButtonAction(int j, int i) {
        putValue(NAME, (j + 1) + ", " + (i + 1));
        row = i;
        col = j;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Look, button @ " + getCol() + "x" + getRow() + " was activated, that was easy...");
    }

}