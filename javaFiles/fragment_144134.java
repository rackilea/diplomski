package simulated_anealing;

public class Crystal extends Thread {

    Object a;

    public  Crystal(Anealable a)
    {
        this.a = a;
    }

}