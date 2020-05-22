public class Example
{
    private JPanel board;

    public Example()
    {
         board = new JPanel();
         getContentPane().add(board);
         //assuming above code takes place in the constructor
         JButton load = new JButton("load");
         load.addActionListener(new ActionListener()
         {
              public void actionPerformed(ActionEvent e)
              {
                    ...lots of code
                    //as board is no longer a local variable this will compile
                    board.add(gridView[row][col]);
              }
         }
    }
}