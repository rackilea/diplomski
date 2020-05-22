public class MainActivity extends Activity implements OnClickListener {

    private Button showdialog;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 
        showdialog=(Button)findViewById(R.id.showdialog);
        showdialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        dialog = new Dialog(MainActivity.this,
                android.R.style.Theme_Translucent);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(R.layout.dialog);
        dialog.setOnKeyListener(new Dialog.OnKeyListener() {

        @Override
        public boolean onKey(DialogInterface arg0, int keyCode,
                KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    //DO NOTHING
                }
                return true;
            }
        });
        dialog.show();  
    } 
}