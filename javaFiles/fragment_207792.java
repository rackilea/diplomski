public class Game extends JFrame {
    private JPanel panel;
    public Game(int rows,int cols,int hgap,int vgap){
        panel=new JPanel(new GridLayout(rows, cols, hgap, vgap));
        for(int i=1;i<=rows;i++)
        {
            for(int j=1;j<=cols;j++)
            {
                JButton btn=new JButton(String.valueOf(i));
                panel.add(btn);
            }
        }
        add(panel);
        pack();
        setVisible(true);
    }
}