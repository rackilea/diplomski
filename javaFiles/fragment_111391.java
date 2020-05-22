import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private EditText myEditText;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button ShowDialog = findViewById(R.id.showdialog_id);
    myEditText = findViewById(R.id.editText_id);

    ShowDialog.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
            final EditText edittext = new EditText(MainActivity.this);
            alert.setTitle("Title");
            alert.setMessage("Message");
            alert.setView(edittext);
            alert.setPositiveButton("Set text", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    String YouEditTextValueX = edittext.getText().toString();
                    if(YouEditTextValueX.length() > 0){

                        //this line for call method and pass the text
                        setTextFromDialog(YouEditTextValueX);
                    }
                }
            });
            alert.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    // what ever you want to do with No option.
                }
            });
            alert.show();
        }
    });
}
private void setTextFromDialog(final String textFromDialog){
    myEditText.setText(textFromDialog);
}
}