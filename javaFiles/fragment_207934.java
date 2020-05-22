public class CreateCallback : Java.Lang.Object, AidcManager.ICreatedCallback
{
    private Action<AidcManager> _successAction;
    public CreateCallback(Action<AidcManager> successAction)
    {
        _successAction = successAction;
    }

    public void OnCreated(AidcManager p0)
    {
        _successAction(p0);
    }
}