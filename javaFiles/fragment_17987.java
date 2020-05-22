while (true)
{
    doStuffNeededAtStartOfLoop();
    int input = getSomeInput();
    if (testCondition(input))
    {
        break;
    }
    actOnInput(input);
}