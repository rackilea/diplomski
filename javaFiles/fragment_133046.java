import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class SmartApp extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

        final Button firstTimeButton = (Button) findViewById(R.id.firstTimeButton);
        firstTimeButton.setOnClickListener(
                new View.OnClickListener()
        {
                        @Override
                        public void onClick(View v)
                        {
                                // TODO Auto-generated method stub
                                Intent userCreationIntent = new Intent(v.getContext(), UserCreation.class);
                                startActivityForResult(userCreationIntent, 0);
                        }
                });
    }
}