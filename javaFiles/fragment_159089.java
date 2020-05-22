public abstract class Robot{

    private String model = "NONAME";

    public Robot() {
        System.out.println("Making a generic " + model + " robot, type: " + this.getClass());
    }

    public String getModel() {
        return model;
    }

    protected void setModel(String str){
        this.model = str;
    }
}