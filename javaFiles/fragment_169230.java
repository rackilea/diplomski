import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

  Button btn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_test);

      btn = (Button) findViewById(R.id.button); //Reference to the button

      btn.setOnClickListener(this); 
  }

  @Override
  public void onClick(View v) {
     DO THIS WHEN CLICKED ON
  }
}