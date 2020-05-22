public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    int i = 0;

    Dialog1 dialog1 = new Dialog1(this, i, new ModifiedListener() {
        @Override
        public void notify(int i) {
            iModified();
        }
    });
    dialog1.show();
}

//Want to call this method whenever I is modified
private void iModified(){

    }
}