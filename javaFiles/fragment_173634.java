public void eatStackThenExecute(int depth, Runnable action)
{
    // Maybe put some locals here (and use them) to eat more stack per iteration?
    if (depth == 0)
    {
        action();
    }
    else
    {
        eatStackThenExecute(depth - 1, action);
    }
}