public interface Output {
     public void print(String msg);
}


class Car {
    private String color;
    private Integer numberOfTires;

    private Output output = (msg) -> System.out.println(msg);

    void setOutput(Output output){
        this.output = Objects.requireNotNull(output);
    }

    public void printCar() {
        output.print("Color: " + color);
        output.print("Number of tires: " + numberOfTires);
    }
}