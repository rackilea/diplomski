import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    private Button B3;
    private Button B4;
    private Button B5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        B3 = findViewById(R.id.button3);
        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToDanceScheduleMenu();
            }
        });

        B4 = findViewById(R.id.button10);
        B4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToWhatsOn();
            }
        });

        B5 = findViewById(R.id.button11);
        B5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToMainResultsMenu();
            }
        });
    }
    private void moveToDanceScheduleMenu () {
        Intent intent = new Intent(Main2Activity.this, DanceScheduleMenu.class);
        startActivity(intent);
    }

    private void moveToWhatsOn () {
        Intent intent = new Intent(Main2Activity.this, WhatsOn.class);
        startActivity(intent);
    }
}