interface GlobalTimerListener {
    void onTick();
}
class GlobalTimer {
    private static List<GlobalTimerListener> listeners = new ArrayList<>();
    public static void register(GlobalTimerListener gtl) {
        listeners.add(gtl);
    }
    static {
        TimerTask tt = new TimerTask() {

            @Override
            public void run() {
                try
                {
                    System.out.println("fired event");
                    //get the event out of here to somewhere in the code that can use it
                    for (GlobalTimerListener listener : listeners) {
                        listener.onTick();
                    }
                }
                catch (Exception ex)
                {
                    System.out.println(ex.toString());
                }
            }
        };
        Timer t = new Timer(true);
        t.scheduleAtFixedRate(tt, 0, 10000);
    }
}