class Car {
    private String color;
    private Integer numberOfTires;

    private PrintStream output = System.out;

    void setOutput(PrintStream output){
        this.output = Objects.requireNotNull(output);
    }

    public void printCar() {
        output.print("Color: " + color);
        output.print("Number of tires: " + numberOfTires);
    }
}