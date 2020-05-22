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
try {
    object = new int[10][10][10][10][10][10][10][10][10][10][10][10];
} catch(OutOfMemoryError err) {
    System.out.println("...");
}