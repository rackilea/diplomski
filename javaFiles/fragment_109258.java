public class MyContent extends Application {

    public static final Map<String, Element> ITEM_MAP;

    @Override
    public void onCreate() {
        super.onCreate();

        ITEM_MAP = new HashMap<String, Element>();
        AssetManager assetManager = getAssets();
        try {
            InputStream inputStream = getAssets().open("data.csv");
            InputStreamReader inputStreamReader=new InputStreamReader((inputStream));
            BufferedReader bufferedReader=new BufferedReader((inputStreamReader));
            String tt="";
            while ((tt=bufferedReader.readLine())!=null){
                MyContent.addItemElement(MyContent.createElement(tt));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}