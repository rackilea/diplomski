public class StatusEventArgs : EventArgs
{
    //...
}

public class Util
{
    public void SomeFunction()
    {
        // ....
        if (this.OnAvailabilityChanged != null)
            OnAvailabilityChanged(this, new StatusEventArgs(status));
    }

    public event EventHandler<StatusEventArgs> OnAvailabilityChanged
}

public class Activity
{
    public void AvailabilityStatusChangedHandler(object sender, EventArgs<Status> eventArgs) 
    {
    }

    public void AnotherFunction()
    {
        utilObj.OnAvailabilityChanged += this.AvailabilityStatusChangedHandler;
    }       
}