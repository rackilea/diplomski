public class Cocos2dxActivity extends Activity {
    private static Cocos2dxActivity instance = null;
   @Override public void onCreate(Bundle b) {
     ...
     this.instance = this;
     }

     public static Cocos2dxActivity getInstance() {
        return instance;
     }



}