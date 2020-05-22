public class Resurrect {

    static Resurrect resurrect = null;

    public static void main(String[] args) {
        Resurrect localInstance = new Resurrect();
        System.out.println("first instance: " + localInstance.hashCode());

        // after this code there is no more reference to the first instance
        localInstance = new Resurrect();
        System.out.println("second instance: " + localInstance.hashCode());

        // will (in this simple example) request the execution of the finalize() method of the first instance
        System.gc(); 
    }

    @Override
    public void finalize() {
        resurrect = this;
        System.out.println("resurrected: " + resurrect.hashCode());
    }
}