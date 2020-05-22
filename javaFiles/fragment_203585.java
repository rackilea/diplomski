public class Cow {
    private String name;
    private int power;
    private int toughness;

    public Cow() {
    }

    public Cow(String name) {
        this.name = name;
        this.power = power;
        this.toughness = toughness;
    }

    public Cow(String name, int power) {
        this.name = name;
        this.power = power;
        this.toughness = toughness;
    }

    public Cow(String name, int power, int toughness) {
        this.name = name;
        this.power = power;
        this.toughness = toughness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getToughness() {
        return toughness;
    }

    public void setToughness(int toughness) {
        this.toughness = toughness;
    }
}