public class Lecturer extends Person {
    double stipend = 9144;

    public Lecturer(String n) {
        super(n);
    }

    public Lecturer(String n, double stipend) {
        super(n);
        this.stipend = stipend;
    }

    public double getStipend() {
        return stipend;
    }

    public void setStipend(double stipend) {
        this.stipend = stipend;
    }

    public void writeOutput() {
        System.out.println("Name: " + this.getName());
        System.out.println("Stipend: " + getStipend());
    }
}