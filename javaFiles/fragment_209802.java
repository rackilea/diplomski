import android.app.Activity; 
import android.content.Intent;
import android.os.Bundle; 
import android.view.View;
import android.view.View.OnClickListener; 
import android.widget.Button;

public class GameMode extends Activity {

Button btn1;
Button btn2;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game_mode);

    btn1=(Button)findViewById(R.id.Back1);
    btn1.setOnClickListener(btn1Listener);

    btn2=(Button)findViewById(R.id.TMode);
    btn2.setOnClickListener(btn2Listener);
}


private OnClickListener btn1Listener=new OnClickListener() {
    public void onClick(View v) {
            Intent intent1=new Intent(GameMode.this,MainActivity.class);
            startActivity(intent2);
        }
    };
private OnClickListener btn2Listener=new OnClickListener() {
    public void onClick(View v) {
            Intent intent1=new Intent(GameMode.this,CharacterSelect.class);
            startActivity(intent2);
        }
    };     
}