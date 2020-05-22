public class USCrimeData {

    private int year;
    private int population;
    private int violentCrime;
    private double violentCrimeRate;
    private int manslaughter;
    private double manslaughterRate;
    private int rape;
    private double rapeRate;
    private int robbery;
    private double robberyRate;
    private int assault;
    private double assaultRate;
    private int propertyCrime;
    private double propertyCrimeRate;
    private int burglary;
    private double burglaryRate;
    private int larcenyTheft;
    private double larcenyTheftRate;
    private int vehicleTheft;
    private double vehicleTheftRate;

    public USCrimeData(String line) {
        String[] split = line.split(",");
        year = Integer.parseInt(split[0]);
        population = Integer.parseInt(split[1]);
        violentCrime = Integer.parseInt(split[2]);
        violentCrimeRate = Double.parseDouble(split[3]);
        manslaughter = Integer.parseInt(split[4]);
        manslaughterRate = Double.parseDouble(split[5]);
        rape = Integer.parseInt(split[6]);
        rapeRate = Double.parseDouble(split[7]);
        robbery = Integer.parseInt(split[8]);
        robberyRate = Double.parseDouble(split[9]);
        assault = Integer.parseInt(split[10]);
        assaultRate = Double.parseDouble(split[11]);
        propertyCrime = Integer.parseInt(split[12]);
        propertyCrimeRate = Double.parseDouble(split[13]);
        burglary = Integer.parseInt(split[14]);
        burglaryRate = Double.parseDouble(split[15]);
        larcenyTheft = Integer.parseInt(split[16]);
        larcenyTheftRate = Double.parseDouble(split[17]);
        vehicleTheft = Integer.parseInt(split[18]);
        vehicleTheftRate = Double.parseDouble(split[19]);
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}