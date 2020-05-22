class MyPanel extends JPanel implements ActionListener{

    private final static int POINTWIDTH = 8;
    private final static Color POINTCOLOR = Color.RED;
    private final static Color LINECOLOR = Color.GREEN;
    private JLabel label =  new JLabel();
    private City city,city2,city3,city4,city5,city6,city7,city8,city9,city10,city11,city12,city13,city14,city15,city16,city17,city18,city19,city20;
    private Population population;
    private ArrayList tempCity = new ArrayList<City>();
    private ArrayList tempCity2 = new ArrayList<City>();

    int delay = 5000;
    private int iteration = 0;

    Timer timer = new Timer(delay, this);


    public void start(){
        iteration = 0;
        timer.start();
    }

    public void initGA() {
        city = new City(60, 200);
        TourManager.addCity(city);
        city2 = new City(180, 200);
        TourManager.addCity(city2);
        city3 = new City(80, 180);
        TourManager.addCity(city3);
        city4 = new City(140, 180);
        TourManager.addCity(city4);
        city5 = new City(20, 160);
        TourManager.addCity(city5);
        city6 = new City(100, 160);
        TourManager.addCity(city6);
        city7 = new City(200, 160);
        TourManager.addCity(city7);
        city8 = new City(140, 140);
        TourManager.addCity(city8);
        city9 = new City(40, 120);
        TourManager.addCity(city9);
        city10 = new City(100, 120);
        TourManager.addCity(city10);
        city11 = new City(180, 100);
        TourManager.addCity(city11);
        city12 = new City(60, 80);
        TourManager.addCity(city12);
        city13 = new City(120, 80);
        TourManager.addCity(city13);
        city14 = new City(180, 60);
        TourManager.addCity(city14);
        city15 = new City(20, 40);
        TourManager.addCity(city15);
        city16 = new City(100, 40);
        TourManager.addCity(city16);
        city17 = new City(200, 40);
        TourManager.addCity(city17);
        city18 = new City(20, 20);
        TourManager.addCity(city18);
        city19 = new City(60, 20);
        TourManager.addCity(city19);
        city20 = new City(160, 20);
        TourManager.addCity(city20);
        population = new Population(50, true);
    }

    public void doGA(){
        population = GA.evolvePopulation(population);
        repaint();
        System.out.println(population.getFittest().getFitness());
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        for(int x = 0; x<19;x++){
            g2.setColor(LINECOLOR);
            //g2.drawLine(tempCity.get(x).getX(), tempCity.get(x).getY(), tempCity2.get(x).getX(), tempCity2.get(x).getY());
            g2.drawLine(population.getFittest().getCity(x).getX(), population.getFittest().getCity(x).getY(), population.getFittest().getCity(x+1).getX(), population.getFittest().getCity(x+1).getY());
            g2.setColor(POINTCOLOR);
            g2.fillOval(population.getFittest().getCity(x).getX() - POINTWIDTH/2, population.getFittest().getCity(x).getY() - POINTWIDTH/2, POINTWIDTH, POINTWIDTH);

        }
        g2.setColor(LINECOLOR);
        g2.drawLine(population.getFittest().getCity(19).getX(), population.getFittest().getCity(19).getY(), population.getFittest().getCity(0).getX(), population.getFittest().getCity(0).getY());
        g2.setColor(POINTCOLOR);
        g2.fillOval(population.getFittest().getCity(0).getX() - POINTWIDTH/2, population.getFittest().getCity(0).getY() - POINTWIDTH/2, POINTWIDTH, POINTWIDTH);

    }

    public void actionPerformed(ActionEvent e){
        iteration++;
        if (iteration < 100) {
            doGA();
        } else {
            ((Timer)e.getSource()).stop();
        }
    }
}