public class SimpleGCExample {
    public static void main(String[] args) throws InterruptedException {
        ReferenceQueue<Object> queue=new ReferenceQueue<>();
        SimpleGCExample e = new SimpleGCExample();
        Reference<Object> pRef=new PhantomReference<>(e, queue),
                          wRef=new WeakReference<>(e, queue);
        e = null;
        for(int count=0, collected=0; collected<2; ) {
            Reference ref=queue.remove(100);
            if(ref==null) {
                System.gc();
                count++;
            }
            else {
                collected++;
                System.out.println((ref==wRef? "weak": "phantom")
                                  +" reference enqueued after "+count+" gc polls");
            }
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalizing the object in "+Thread.currentThread());
        Thread.sleep(100);
        System.out.println("done finalizing.");
    }
}