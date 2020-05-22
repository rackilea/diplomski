//...preceding code before line 324 ...

public class DrawingBoard extends JComponent
{

    private static final long serialVersionUID = -4431176095451940075L;

    // ArrayList<Shape> shapes = new ArrayList<Shape>();
    ArrayList<Color> shapeStroke = new ArrayList<Color>();
    ArrayList<Integer> count = new ArrayList<Integer>();
    ArrayList<NamedShape> shapes = new ArrayList<NamedShape>();
    ArrayList<Connection> con = new ArrayList<Connection>();

    public ArrayList<Connection> getConnection()
    {
       return con;
    }

    public class Connection
    {
    // ... rest of your code...