class X
{
    // ...

    void popUntil(Class<? extends Screen.Type> type)
    {
        // go through the list in reverse order
        while( screens.next().getClass() != type)
        {
            screens.pop();
        }
    }
}

x.popUntil(Screen.Type.MainScreen.class);
x.popUntil(Screen.Type.GameScreen.class);