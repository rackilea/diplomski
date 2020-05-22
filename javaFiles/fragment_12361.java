import java.util.Random;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Main extends Activity {
    TextView diceScore;
    RelativeLayout mainLayout;
    Button shakeDice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shakeDice = (Button) findViewById(R.id.shakeDice);


    shakeDice.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View arg0) {
            randomDiceNumber();

        }
    });

}


@SuppressWarnings("deprecation")
public void randomDiceNumber() { 
    int diceNumber = 0;
    int max = 6;
    int min = 1;

    Random r = new Random();
    diceNumber = r.nextInt(max - min + 1) + min;
    diceScore = new TextView(this);
    diceScore.setText(String.valueOf(diceNumber));
    diceScore.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT)         );
    mainLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
    mainLayout.addView(diceScore);

    }
}