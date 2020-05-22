public class Pencere{
    JFrame pencere = new JFrame();
    JButton buton1, buton2;

    public Pencere() {
        pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pencere.setTitle("Ana Pencere");
        pencere.setBackground(Color.getHSBColor(15f, 120f, 220f));
        pencere.setLocation(new Point(500, 300));
        pencere.setSize(613, 253);
        //pencere.addMouseListener(new Dinle());
        pencere.setLayout(new FlowLayout());
        pencereDegis();
    }
    public void goster(){
        pencere.setVisible(true);
    }

    public void pencereDegis(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        buton2 = new JButton("Butonnn"); //This button not visible
        pencere.add(buton2);
        pencere.pack();
    }

    public static void main(String[] args)
    {
        Pencere p = new Pencere();
        p.goster();
    }
}