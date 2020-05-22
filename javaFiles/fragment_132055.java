public class OMG {
    int hi=2;
    public static void main(String args[]) {
        //note that we have to create a new instance of OMG
        //because, again, static methods cannot access to non-static methods/fields
        OMG omg = new OMG();
        omg.letsDoIt();
        System.out.println(omg.hi);
    }
    public void letsDoIt() {
        this.hi+=1;
    }
}