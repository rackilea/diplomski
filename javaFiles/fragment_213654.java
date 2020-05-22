public abtract class Monitor<T extends MonitorAccount>
{
    ...
    public abstract List<? extends T> performMonitor(
        List<? extends T> accounts);
}

public class EmailMonitor extends Monitor<EmailAccount>
{
    @Override
    public abstract List<? extends EmailAccount> performMonitor(
        List<? extends EmailAccount> accounts)
    {
        // Code goes here
    }
}