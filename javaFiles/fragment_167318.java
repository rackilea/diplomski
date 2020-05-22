boolean done = false;
while (!done)
{
    try
    {
        one.join();
        two.join();
        three.join();
        four.join();
        done = true;
    }
    catch (InterruptedException e)
    {
        // Handle interrupt determine if need to exit.
    }
}