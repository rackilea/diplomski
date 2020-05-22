package sudoku;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Main 
{

public static void main(String[] args) 
{
    Sudoku s = new Sudoku();
    s.setSize(400, 400);

    //Center the JFrame
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    s.setLocation(dim.width/2-s.getSize().width/2, dim.height/2-s.getSize().height/2);

    //Close application when the user clicks the X
    s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    s.show();
    s.solve(s);
}