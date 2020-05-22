Object object = new Object();
ReferenceQueue queue = new ReferenceQueue();
SoftReference softReference= new SoftReference(object, queue);
new Thread(() -> {
    try { queue.remove(); } catch (InterruptedException ex) {}
Object object = new Object();
ReferenceQueue queue = new ReferenceQueue();
SoftReference softReference= new SoftReference(object, queue);
new Thread(() -> {
    try {
        queue.remove();
        System.out.println("collected");
    } catch (InterruptedException ex) {}
}).start();
object = null;

Thread.sleep(500);
softReference.clear();
softReference.enqueue();