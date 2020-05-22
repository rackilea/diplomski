public class EventBus {

    // our observers
    private static HashMap<IObserver, Class<?>> m_Observers = new HashMap<IObserver, Class<?>>();
    // our incoming events
    private static BlockingQueue<AEvent<?>> incoming = new LinkedBlockingQueue<AEvent<?>>();

    // start our internal thread
    static {
        new Thread(new DelegationThread()).start();
    }

    // subscribe an observer
    public static void subscribe(IObserver obs, Class<?> evtClass) {
        synchronized (m_Observers) {
            m_Observers.put(obs, evtClass);
        }
    }

    // publish and event
    public static void publishAsync(AEvent<?> event) {
        incoming.add(event);
    }

    private static class DelegationThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    AEvent<?> evnt = incoming.take();
                    synchronized (m_Observers) {
                        for (Entry<IObserver, Class<?>> entry : m_Observers.entrySet()) {
                            if (entry.getValue() == evnt.getClass()) {
                                entry.getKey().update(evnt);
                            }
                        }
                    }
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}