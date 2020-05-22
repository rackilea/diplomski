public class ThisHere {
    public String aww;
    public String notYet = this.aww;

    GedankenExperiment wat = new GedankenExperiment(this);

    // public class GedankenExperiment {
    //     public GedankenExperiment(thatThere) {
    //         thatThere.aww = ???
    //     }
    // }

    public ThisHere() {
        this.aww = "Hi there";
    }

    public static void main(String[] args) {
        ThisHere thisHere = new ThisHere();
        System.out.println("aww=" + thisHere.aww);
        // > aww=Hi there (initialized in ctor)
        System.out.println("notYet=" + thisHere.notYet);
        // > notYet=null (initialized before ctor)
    }
}