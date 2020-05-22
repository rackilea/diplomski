public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences=getSharedPreferences("File_name",MODE_PRIVATE);
        editor=preferences.edit();

        submit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                view.setText((habbit.getText().toString() + " for $" + money.getText().toString()) + "/day");

                editor.putString("key",habbit.getText().toString());
                editor.commit();

            }
        });
}