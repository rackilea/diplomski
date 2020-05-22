private static boolean listenerAdded = false;
@Override 
public void run(RunNotifier notifier)
{
    //listenerAdded required or else the listener will be added once for every test case, and testRunFinished will be run multiple times
    if(!listenerAdded)
    {
        listenerAdded = true;
        notifier.addListener(new MyRunListener());
    }
    super.run(notifier);
}