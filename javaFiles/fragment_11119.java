import javax.swing.JPanel;

public class MainClass extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);          
       //variable of the begin of point
        int pointIni=0;
        //variable for the distance between lines
        int distance=20;
        //variable for the space between lines
        int cntLines=20;
        for (int i = 0; i < cntLines; i++) 
        {
           g.drawLine(0, 0, pointIni, getHeight()-pointIni);         
           pointIni=pointIni+distance;
        }
    }

    public static void main(String[] args) {
        JFrame myFrame = new JFrame();
        MainClass panel = new MainClass();
        myFrame.add(panel);
        myFrame.setSize(400, 400);
        myFrame.setLocation(100, 100);
        myFrame.setVisible(true);
    }
}