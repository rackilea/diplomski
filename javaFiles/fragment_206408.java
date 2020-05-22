class Foo{
    static final double G = .00000000006667;
    private int Mass1;
    private int Mass2;
    private int Dist=1;//defaulting to avoid division by zero

    public int getMass1(){return mass1;}
    public void setMass1(int mass1){this.mass1=mass1;}
    ....

    public double getGravitationalForce(){
        return (G * Mass1 * Mass2) / (Dist * Dist);
    }
}