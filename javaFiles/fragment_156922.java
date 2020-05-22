catch(final Throwable ex)
{
    final Throwable cause;

    if(ex.getCause() == null)
    {
        cause = ex;
    }
    else
    {
        cause = ex.getCause();
    }

    if(cause instanceof AttemptToExitException)
    {
        status = ((AttemptToExitException)cause).getStatus();
    }
    else
    {
        throw cause;
    }
}

assertEquals("System.exit must be called with the value of " + expectedStatus, expectedStatus, status);