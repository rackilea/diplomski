boolean running = true;
while (running)
{
    doStuffNeededAtStartOfLoop();
    int input = getSomeInput();
    if (testCondition(input))
    {
        running = false;
    }
    else
    {
        actOnInput(input);
    }
}