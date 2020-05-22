public class WadusActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public class SomeOtherClass{
        public SomeOtherClass(){
            WadusActivity.this.finish(); //This calls the activity finish
            finish(); //This calls the method below
        }
        public void finish(){
            //method also named finish
        }
    }
}