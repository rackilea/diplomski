public class Semaphore {
    private Queue<Object> queue;
    private int state;

    public Semaphore() {
        this.queue = new LinkedList<Object>();
    }

    public void acquire() {
        Object object = new Object();

        synchronized (object) {
            try {
                if (this.state > 0) {
                    this.queue.add(object);
                    object.wait();                  
                }  else {
                    state++;
                }

            } catch (InterruptedException ie) {
            }

        }
    }

    public void release() {
        Object object = this.queue.poll();

        state--;

        if(null == object) {
            return;
        }

        synchronized (object) {
            object.notify();
        }
    }
}