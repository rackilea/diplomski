import f.q.c.n.Event;

public class JNIEventTest {

    static {
        System.loadLibrary("native");
    }

    private native Event retrieveNativeEvent();


    public static void main(String[] args) {
        JNIEventTest jniEventTest = new JNIEventTest();
        Event event = jniEventTest.retrieveNativeEvent();
        System.out.println("eventType: " + event.eventType);
        System.out.println("meta: " + event.meta);
    }
}