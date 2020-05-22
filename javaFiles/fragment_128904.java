long lastCall = 0;
void doSomething()
{
    long now = secondsSinceEpoch();
    if (lastCall == 0 || now-lastCall > 5)
    {
        // Do stuff
        // lastCall = now
    }
}