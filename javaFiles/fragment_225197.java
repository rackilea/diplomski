public class ProportionalBalons extends JPanel {
    private String currencyCostumerHas;
    private String currencyCostumerWants;
    private double exchangeRate = args[2];

    public ProportionalBalons(int currencyCustumerHas, String currencyCustumerWants, exchangeRate) {
        this.currencyCostumerHas = currencyCostumerHas;
        this.currencyCostumerWants = currencyCostumerWants;
        this.exchangeRate = exchangeRate;
    }

    public void paintComponent(Graphics g) {
        double balon1Diameter = costumerDeposit;
        double balon2Diameter = costumerDeposit * exchangeRate;
        //ballon 1
        g.drawOval(10, 10, balon1Diameter, balon1Diameter);
        //ballon 2 
        g.drawOval(60 * 8, 10, balon2Diameter, balon2Diameter);
    }
}