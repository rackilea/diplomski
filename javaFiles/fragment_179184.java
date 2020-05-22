public class TimedEventQueue extends EventQueue {
    @Override
    protected void dispatchEvent(AWTEvent event) {
        long startNano = System.nanoTime();
        super.dispatchEvent(event);
        long endNano = System.nanoTime();

        if (endNano - startNano > 50000000)
            System.out.println(((endNano - startNano) / 1000000)+"ms: "+event);
    }
}