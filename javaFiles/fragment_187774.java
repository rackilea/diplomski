public class MyPanel extends JPanel{

    public MyPanel(){
       setBackground(Color.WHITE);             
    }   

    public synchronized void paintComponent(Graphics g) {
        super.paintComponent(g);
        // your paint code    
    }

}