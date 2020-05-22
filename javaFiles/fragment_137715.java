public class Util
{
    public void Function(String s, ISetAvailabilityStatusListener setStatusListener)
    {
        // ....
    }

    public interface ISetAvailabilityStatusListener {
        public void SetAvailabilityStatus(Status status);
    }
}

public class Activity
{
    private class MySetAvailabilityStatusListener: Util.ISetAvailabilityStatusListener
    {
        public void SetAvailabilityStatus(Status status) 
        {
            // do your handling, but nested classes have some differences with anonymous Java classes, so it may require additional infrastructure.
        }
    }

    public void AnotherFunction()
    {
        utilObj.Function("name", 
            new MySetAvailabilityStatusListener())
    }       
}