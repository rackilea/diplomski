public class SecondClass {

  private Context mContext;

  public SecondClass(Context context) {
    mContext = context;
  }

  // then use it on your method
  public void doSomethingWithAsset() {
    AssetManager assetManager = mContext.getResources().getAssets();
    InputStream stream = assetManager.open("myJson.json");
  }
}