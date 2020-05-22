public class Testing1 extends JFrame
{
    private DrawingBoard drawPanel;

    public DrawingBoard getDrawingBoard()
    {
        return drawPanel;
    }

    //...The rest of your existing code except !!!
    // !!! in the Testing1 constructor at line 238 !!!
    // change          final DrawingBoard drawPanel = new DrawingBoard(); to

        drawPanel = new DrawingBoard();

    // ... and the rest of your code...

}