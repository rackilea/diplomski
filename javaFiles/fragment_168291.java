import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
// import package.path.to.Conversion; 

public class MainActivity extends AppCompatActivity {

// Declare your instance variables here
private EditText inputMiles, inputInches, inputFeet;
private TextView convertedMiles, convertedInches, convertedFeet;

@Override
protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initialization();
}

private void initialization()
{
    // Setup your instance variables here
    inputMiles = (EditText) findViewById(R.id.miles);
    inputInches = (EditText) findViewById(R.id.inches);
    inputFeet = (EditText) findViewById(R.id.feet);

    convertedMiles = (TextView) findViewById(R.id.milesOutput);
    convertedInches = (TextView) findViewById(R.id.inchesOutput);
    convertedFeet = (TextView) findViewById(R.id.feetOutput);

    // Just setup your CheckBox in your init method. You call
    // onButtonClick() which would immediately do this anyway
    // I'd also just setup an OnCheckedChangeListener like this
    CheckBox check = (CheckBox) findViewById(R.id.checkBox);
    check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked) CmToMConversion();
            else onButtonClick();     
        }
     });

    Button button = (Button) findViewById(R.id.button);
    // If you're only using the onClickListener for this one button
    // just setup the listener in line rather than making an instance
    // variable of it and referencing it
    button.setOnClickListener(new View.OnClickListener() {
         public void onClick(View v) {
             onButtonClick();
         }
     });
    onButtonClick();
}

private void onButtonClick()
{
    String miles = Conversion.MilesToCmConversion(inputMiles.getText().toString());
    convertedMiles.setText(miles + " cm");

    String inches = Conversion.InchesToCmConversion(inputInches.getText().toString());
    convertedInches.setText(inches + " cm");

    String feet = Conversion.FeetToCmConversion(inputFeet.getText().toString());
    convertedFeet.setText(feet + " cm");
}

// This method manipulates MainActivity's views, so it should be in MainActivity
private void CmToMConversion()
{
    String miles = Conversion.MilesToMConversion(inputMiles.getText().toString());
    convertedMiles.setText(miles + " m");

    String inches = Conversion.InchesToMConversion(inputInches.getText().toString());
    convertedInches.setText(inches + " m");

    String feet = Conversion.FeetToMConversion(inputFeet.getText().toString());
    convertedFeet.setText(feet + " m");
}
}