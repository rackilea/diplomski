CyclicBarrier barrier;

Consumer consumer;

public EndUser(CyclicBarrier barrier) {
    super();
    this.barrier = barrier;
}

public EndUser(CyclicBarrier barrier, Consumer consumer) {
    super();
    this.barrier = barrier;
    this.consumer = consumer;
}


public Consumer getConsumer() {
    return consumer;
}

public void setConsumer(Consumer consumer) {
    this.consumer = consumer;
}


public CyclicBarrier getBarrier() {
    return barrier;
}


public void setBarrier(CyclicBarrier barrier) {
    this.barrier = barrier;
}


@Override
public void run() {
    try
    {
        while(true)
        {
            System.out.println(consumer.getValue());
            barrier.await();
        }
    }
    catch (InterruptedException e) {
        e.printStackTrace();
    } catch (BrokenBarrierException e) {
        e.printStackTrace();
    }

}