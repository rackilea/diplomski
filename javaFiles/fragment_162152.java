public class ActivityB extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dialog loader_dialog = new Dialog(context,android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        loader_dialog.setContentView(R.layout.loading_screen);
        loader_dialog.show();  

        ...
    }