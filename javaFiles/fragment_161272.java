public class JFrameExample {

    public static void main(String[] args) throws MalformedURLException, IOException {
        final JButton j;      
        BufferedImage imgOne = ImageIO.read(new URL("http://www.suptechnology.ma/entrepot/logocert/logocert-20130211115413.png"));
        BufferedImage imgTwo = ImageIO.read(new URL("http://market.milouz.com/data/icon53.png"));

        final ImageIcon imageIconOne = new ImageIcon(imgOne);
        final ImageIcon imageIconTwo = new ImageIcon(imgTwo);

        JFrame f = new JFrame("This is a test / Image on hover");
        f.setSize(500, 500);
        Container content = f.getContentPane();
        content.setLayout(new FlowLayout()); 
        j = new JButton(imageIconOne);
        j.addMouseListener(new MouseListener() {            
            @Override
            public void mouseReleased(MouseEvent arg0) {}           
            @Override
            public void mousePressed(MouseEvent arg0) {}            
            @Override
            public void mouseExited(MouseEvent arg0) { 
                j.setIcon(imageIconOne);
            }           
            @Override
            public void mouseEntered(MouseEvent arg0) {
                    j.setIcon(imageIconTwo);
            }           
            @Override
            public void mouseClicked(MouseEvent arg0) {}
        });
        content.add(j);     
        f.setVisible(true);
  }
}