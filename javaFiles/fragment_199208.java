@Override
public void run()
{
    ....
    if (Thread.interrupted()) {
        // Release resources and end task
    }
    ....
}