public class Pet{

    private String name;
    private double weight;

    public String getName()
    {
        return name;
    }

    protected void setName(String newName)
    {
        name = newName;
    }

    public Pet(String petName) {
        name = petName;
    }

    public void setWeight(double newWeight){
    weight = newWeight;
    }

    public double getWeight(){
    return weight;
    }
}