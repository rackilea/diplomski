import java.awt.*;
import javax.swing.*;

public class BoardTest
{
    private static void createAndShowGUI()
    {
        Float constraint = new Float(1);

        RelativeLayout boardLayout = new RelativeLayout(RelativeLayout.Y_AXIS);
        boardLayout.setRoundingPolicy( RelativeLayout.EQUAL );
        boardLayout.setFill(true);

        JPanel board = new JPanel(boardLayout);
        board.setBackground(Color.GREEN);

        RelativeLayout rowLayout = new RelativeLayout(RelativeLayout.X_AXIS);
        rowLayout.setRoundingPolicy( RelativeLayout.EQUAL );
        rowLayout.setFill(true);

        for (int j = 0; j < 20; j++)
        {
            JPanel row = new JPanel( rowLayout );

            for (int i = 0; i < 20; i++)
            {
                JPanel square = new JPanel();
                square.setBackground((i + j) % 2 == 0 ? Color.BLACK : Color.WHITE);
                row.add(square, constraint);
            }

            board.add(row, constraint);
        }

        JFrame frame = new JFrame("BoardTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(board);
        frame.pack();
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater( () -> createAndShowGUI() );
/*
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
*/
    }
}