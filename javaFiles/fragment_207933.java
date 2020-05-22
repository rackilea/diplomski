public class MyActivity : Activity 
{
    private static BarcodeReader _barcodeReader;
    private AidcManager _manager;
    protected override void OnCreate(Bundle bundle)
    {
        base.OnCreate(bundle);
        // Set our view from the "main" layout resource
        SetContentView(Resource.Layout.Main);

        CreateCallback callback = new CreateCallback(OnManagerCreated) {  };
        AidcManager.Create(this, callback);
    }

    private void OnManagerCreated(AidcManager manager)
    {
        _manager = manager;
        _barcodeReader = manager.CreateBarcodeReader();
    }
}