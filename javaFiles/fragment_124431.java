public void handle()
{
    for (IView view : this.views)
    {
        view.render(new Object());
    }
}