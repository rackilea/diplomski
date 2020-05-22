public class Entry
{
    private String model;
    private int number;
    private String company;

    public Entry(String model, int number, String company)
    {
        this.model = model;
        this.number = number;
        this.company = company;
    }

    public Integer getNumber()
    {
        return number;
    }

    @Override
    public String toString() 
    {
        return "model: " + model + ", number: " + number + ", company: " + company;
    }
}