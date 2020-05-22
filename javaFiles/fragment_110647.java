:
:
import javax.swing.JPanel;

enum Job{SPAWN, KING, NORM};
enum myColor{RED, BLACK};

//This is where current variable declarations are. Move them inside class.

public class Tile
{
    //This is where variable declarations are moved to. 
    int tileRow;
    int tileCol;
    Job job;
    myColor side;
    JButton button;
    Checker piece;
    Color color;

    public Tile(int posRow, int posCol, JPanel panel, ActionListener listener)
    {
        int tileRow = posRow;
        :
        :