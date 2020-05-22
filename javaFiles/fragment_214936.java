public class MainActivity extends AppCompatActivity {
        SharedPreferences prefs;
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                //When the activity starts, we look into the shared prefs and get an int of name "ok_clicked" from it.
                //0 will be the default value of the int if there is no int stored in sharedPreferences.
                prefs = getSharedPreferences("myPrefs", MODE_PRIVATE);
                int times = prefs.getInt("ok_clicked", 0);
                //if the times value is 0, we will open the dialog, otherwise nothing happens
                if (times==0){
                    openDialog();
                }
            }
            //Read This comment First: We will create a Method, which create an alert Dialog.
            private void openDialog(){
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle("Test").setMessage("Lorem ipsum dolor");
                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //When OK button is clicked, an int with value of 1 will be saved in sharedPreferences.
                        prefs = getSharedPreferences("myPrefs", MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("ok_clicked", 1);
                        editor.apply();
                    }
                });
                dialog.setNegativeButton("No Thanks", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    //Second Edit: To open another acitivty on No Thanks Button
                    Intent intent = new Intent(MyActivity.this, HomeActivity.class);                                   
                    startActivity(intent);
                   }
                });
                dialog.show();
            }
        }