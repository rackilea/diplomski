public OknoFunkcji(String title) {
         super(title);
         System.out.println("3rd checkpoint: A " + a + " B " + b + " C " + c + " D " + d);
  }

  public void createChart(double dA, double dB, double dC, double dD) {
        setData(dA,dB,dC,dD);
        JPanel chartPanel = createDemoPanel();
        chartPanel.setSize(500, 270);
        setContentPane(chartPanel);
        revalidate();
        repaint();        
    }

    public void setData(double dA, double dB, double dC, double dD) {
        a = dA;
        b = dB;
        c = dC;
        d = dD;
        System.out.println("2nd checkpoint: A " + a + " B " + b + " C " + c + " D " + d);
    }