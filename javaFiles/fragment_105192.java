public class TaxChart {

    private int[] income;

    public TaxChart(int[] income) {
        this.income = income;
        this.income[0] = 100;
        this.income[1] = 120;
        this.income[2] = 130;
        this.income[3] = 160;
        this.income[4] = 320;
    }

    public void draw() {
        //TaxChart incomes = new TaxChart();

        //  ...
    }

    public static void main(String[] args) {
        TaxChart taxChart = new TaxChart(new int[5]);
        taxChart.draw();
    }
}