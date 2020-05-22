public class test implements CountdownTextTickListener {

    public test() { }

    public void start() {
        CountdownText ctx = new CountdownText(100);
        ctx.setListener(this);
        ctx.Start();
    }

    @Override
    public void CountdownTextTickEventFired(Object sender, 
                        CountdownTextTickEventArgs eventArgs) {
            System.out.println(eventArgs.TimeString);
            if(eventArgs.isStopped) System.out.println("- END -");
    }
}