package android.application.project.planes;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityPaper extends Activity implements OnClickListener {

    TextView text1, title1;
    Button save1, update1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_activity_paper);

        text1 = (TextView) findViewById(R.id.editText1);
        title1 = (TextView) findViewById(R.id.editText3);
        save1 = (Button) findViewById(R.id.button3);
        update1 = (Button) findViewById(R.id.button5);

        save1.setOnClickListener(this);
        update1.setOnClickListener(this);

    }

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub

        switch (arg0.getId()) {
        case R.id.button3:

            String titles = title1.getText().toString();
            String notes = text1.getText().toString();

            MainActivityChampagne entry = new MainActivityChampagne(
                    MainActivityPaper.this);
            entry.open();
            entry.createEntry(titles, notes);
            entry.close();

            break;

        case R.id.button5:

            String thetitles = title1.getText().toString();
            String thenotes = text1.getText().toString();

            MainActivityChampagne up = new MainActivityChampagne(
                    MainActivityPaper.this);
            up.open();
            up.updateEntry(thetitles, thenotes);
            up.close();

            break;

        }

    }

}