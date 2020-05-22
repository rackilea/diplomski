public class GUID {

    private static int GUID = 0;

    public synchronized static void increment() {
        GUID++;
    }
}

abstract class ParentObject {

    ParentObject() {

        GUID.increment();

        // constructor's stuff
    }

}