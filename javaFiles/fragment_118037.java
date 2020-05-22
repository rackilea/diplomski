public class Button extends JButton {
    private int row = 0;
    private int column = 0;

    public Button(int row, int column) {
        super();

        this.row = row;
        this.column = column;    
    }
    public int getRow() {return row;}
    public int getColumn() {return column;}
}