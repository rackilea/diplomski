public class MainClass {
    private int firstVal;
    //its value can be retrieved by any class
    public int getFirstVal() {
        return this.firstVal;
    }
    //its value can only be modified by subclasses of MainClass
    protected void setFirstVal(int firstVal) {
        this.firstVal = firstVal;
    }
    //similar for the other field...
}