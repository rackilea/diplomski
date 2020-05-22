public class MathParams {
    private int numd;
    private int numf;
    private int nump;

    public MathParams(int numd, int numf, int nump) {
        this.numd = numd;
        this.numf = numf;
        this.nump = nump;
    }

    public double doCalc0(int i) {
        return (Math.E * Math.exp(-numd * i) * Math.sin(i * numf + nump));
    }

    public double doCalc1(int i) {
        return (Math.E * Math.exp(-numd * i) * Math.sin(i * numf * nump));
    }
}