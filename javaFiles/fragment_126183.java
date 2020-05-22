public class MoveAction extends AbstractAction {

    private int colDelta;
    private int rowDelta;

    public MoveAction(int colDelta, int rowDelta) {
        this.colDelta = colDelta;
        this.rowDelta = rowDelta;
    }

    public int getColDelta() {
        return colDelta;
    }

    public int getRowDelta() {
        return rowDelta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Component owner = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
        if (owner instanceof JButton) {
            JButton btn = (JButton) owner;
            Action action = btn.getAction();
            if (action instanceof ButtonAction) {
                ButtonAction ba = (ButtonAction) action;
                int row = ba.getRow();
                int col = ba.getCol();

                do {
                    row += getRowDelta();
                    col += getColDelta();
                    if (row < 0) {
                        row = buttons.length - 1;
                    } else if (row >= buttons.length) {
                        row = 0;
                    }

                    if (col < 0) {
                        col = buttons[row].length - 1;
                    } else if (col >= buttons[row].length) {
                        col = 0;
                    }
                } while (!buttons[row][col].isVisible());

                buttons[row][col].requestFocusInWindow();
            }
        }
    }

}