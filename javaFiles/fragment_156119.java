package test.gc;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

public class TestSoftReference {

    public static ReferenceQueue<TestModel> referenceQueue = new ReferenceQueue<>();
    public static ConcurrentHashMap<Integer, SoftReference<TestModel>> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        final int KEY1 = 1;

        TestModel testModel1 = new TestModel(KEY1);
        SoftReference<TestModel> reference1 = new SoftReference<TestModel>(testModel1, referenceQueue);

        map.put(testModel1.getNumber(), reference1);

        testModel1 = null;

        while (true) {  
            Object obj = referenceQueue.poll();  
            if (obj != null) {  
                System.out.println("queue.poll at " + new Date() + " " + obj);
                break;  
            }  
            System.gc();  
        }  

        SoftReference<TestModel> tempReference = null;
        tempReference = map.get(KEY1);
        System.err.println("reference:" + tempReference);
        if (tempReference != null) {
            System.err.println("referent:" + tempReference.get());
        }
    }

}

class TestModel {

    private int number = 0;
    private int[] bigArray = null;

    public int getNumber() {
        return number;
    }

    public TestModel(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("argument n must greater than 0.");
        } else {
            number = n;
            bigArray = new int[n * 1024 * 1024];
        }
    } 

    @Override
    public String toString() {
        return "field bigArray's baseNumber is " + number + " and bigArray's length is " + bigArray.length;
    }

}