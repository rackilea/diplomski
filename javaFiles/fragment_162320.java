import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Text extends AppCompatActivity {
    Context context;
    Button button;

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.text_wall);
    Spinner spinner = (Spinner) findViewById(R.id.LanguagePicker);
    button = (Button) findViewById(R.id.ConfirmationButton);
    context = this; // why this? why using context when you have this?


    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
            R.array.language, android.R.layout.simple_spinner_item);

    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    spinner.setAdapter(adapter);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LayoutInflater li = LayoutInflater.from(context);
            View promptsView = li.inflate(R.layout.alertdialog, null);

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    context);


            alertDialogBuilder.setView(promptsView);
            alertDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {

                                    Spinner spinner = (Spinner) findViewById(R.id.LanguagePicker);
                                    String text = spinner.getSelectedItem().toString();
                                }
                            })
                    .setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    });
}

}