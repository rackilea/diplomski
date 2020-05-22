public class Terminator extends Robot {
    private String model;

    public Terminator(String model) {
        super();
        System.out.println("Making a " + model + " terminator, type: " + this.getClass());
        this.model = model;
    }

    @Override
    public String getModel(){
    return model;
    }
}