public void SetView(View screen)
{   
    if (!screens.empty())
    {
        screens.peek().onPause();
        screens.pop();
    }

    screens.push(screen);
    setContentView(screens.peek());
}