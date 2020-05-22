package hr.hello.dm.test;

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

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, View.OnClickListener {

    private ArrayList<View> gridButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get all the buttons from the grid - be careful if you add another type of Touchable
        gridButtons = ((GridLayout) findViewById(R.id.tabellaX)).getTouchables();

        for (View v : gridButtons) {
            ((Button) v).setOnLongClickListener(this);
            ((Button) v).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        if(((Button) v).((Button) v).getText().toString().isEmpty()) 
            return;

        int value = Integer.parseInt(((Button) v).getText().toString());
        for (View btn : gridButtons) {
            if(v.getId() != btn.getId() && !((Button) btn).getText().toString().isEmpty()) {
                int btnValue = Integer.parseInt(((Button) btn).getText().toString());
                ((Button) btn).setText(String.valueOf((value + btnValue)%10));
            }
        }

    }

    @Override
    public boolean onLongClick(View v) {

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
                    int value = Integer.parseInt(input.getText().toString());
                    ((Button) v).setText(String.valueOf(value));

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