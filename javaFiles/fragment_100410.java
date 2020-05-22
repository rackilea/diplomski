public class Element {

    private int atomicNumber;
    private double atomicMass;
    private String atomicSymbol;
    private String atomicName;

    public Element(int atomicNumber, double atomicMass, String atomicSymbol, String atomicName) {
        this.atomicNumber = atomicNumber;
        this.atomicMass = atomicMass;
        this.atomicSymbol = atomicSymbol;
        this.atomicName = atomicName;
    }

    public double getAtomicMass() {
        return atomicMass;
    }

    public void setAtomicMass(double atomicMass) {
        this.atomicMass = atomicMass;
    }

    public String getAtomicSymbol() {
        return atomicSymbol;
    }

    public void setAtomicSymbol(String atomicSymbol) {
        this.atomicSymbol = atomicSymbol;
    }

    public String getAtomicName() {
        return atomicName;
    }

    public void setAtomicName(String atomicName) {
        this.atomicName = atomicName;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public void setAtomicNumber(int atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    @Override
    public String toString() {
        return "atomicMass: " + atomicMass
            + " | atomicSymbol: " + atomicSymbol
            + " | atomicName: " + atomicName
            + " | atomicNumber: " + atomicNumber;
    }
}