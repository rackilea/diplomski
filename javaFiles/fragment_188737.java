import java.util.ArrayList;
import java.util.Collection;

public class MainClass implements ResultReceiver {

    public static void main(String[] args) {

        SeparateThread separateThread = new SeparateThread();
        separateThread.registerForResult(new MainClass());
        separateThread.registerForResult(new OtherClass1());
        separateThread.registerForResult(new OtherClass2());
        separateThread.start();
    }

    @Override
    public void receive(String result) {
        System.out.println("MainClass.receive(\"" + result + "\")");
    }

}

class SeparateThread extends Thread {

    private static final Collection<ResultReceiver> receivers = new ArrayList<>();

    public void registerForResult(ResultReceiver receiver) {
        receivers.add(receiver);
    }

    @Override
    public void run() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = "Hello" + " " + "world";

        for (ResultReceiver receiver : receivers) {
            receiver.receive(result);
        }
    }

}

class OtherClass2 implements ResultReceiver {

    @Override
    public void receive(String result) {
        System.out.println("OtherClass2.receive(\"" + result + "\")");
    }

}

class OtherClass1 implements ResultReceiver {

    @Override
    public void receive(String result) {
        System.out.println("OtherClass1.receive(\"" + result + "\")");
    }

}

interface ResultReceiver {
    void receive(String result);
}