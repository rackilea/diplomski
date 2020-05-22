import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get all the buttons from the grid - be careful if you add another type of Touchable
        ArrayList<View> gridButtons = ((GridLayout) findViewById(R.id.tabellaX)).getTouchables();

        for (View v : gridButtons) {
            ((Button) v).setOnLongClickListener(this);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        // show the dialog ONLY if the button isn't set
        if (((Button) v).getText().toString().isEmpty())
            showDialog(v);

        return true;
    }

    private void showDialog(final View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Input a number");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // get only the first inserted number(i.e. input: 45; take only the 4)
                ((Button) v).setText(input.getText().toString().substring(0, 1));
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }


}