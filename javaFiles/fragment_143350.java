import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class wazeefa extends Activity{

TextView txtCount;
Button btnCount;
int count = 0;  

@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.wazeefa);

    //button sound
    final MediaPlayer mpButtonClick = MediaPlayer.create(this, R.raw.countbutton);

    txtCount = (TextView)findViewById(R.id.wcount); 
    txtCount.setText(String.valueOf(count));
    btnCount = (Button)findViewById(R.id.wclick);       

    btnCount.setOnClickListener(new OnClickListener() {
         public void onClick(View V) {
            count++; 
            txtCount.setText(String.valueOf(count));
            mpButtonClick.start();

            if (count >= 500) {
               count = 0;
            }
        }
        });
}}