@Override
public boolean isCellSelected(final int row, final int column)
{
    if (mousingInProgress && row == mousingRow)
    {
        // Only lie to the canStartDrag caller. We tell the truth to everyone else.
        final StackTraceElement[] elms = Thread.currentThread().getStackTrace();
        for (int i = 0; i < 3; i++)
        {
            if (elms[i].getMethodName().equals("canStartDrag"))
            {
                return mousingInProgress;
            }
        }
    }
    return super.isCellSelected(row, column);
}