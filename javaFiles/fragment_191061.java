public class MonthlyRecord {

    private String month;
    private int day;
    private double[] moneyDaily;

    public MonthlyRecord() {
        this.month = "January";
        this.day = 0;
        this.moneyDaily = new double[1]; //variable is instantiated to have one slot as default
    }

    public MonthlyRecord(String name, int day) {

        System.out.println("Hello");
        this.setMonthlyRecord(name);
        this.setDays(day);
        moneyDaily = new double[days]; //array gets instantiated with number of slots equal to the value of the day variable
    }