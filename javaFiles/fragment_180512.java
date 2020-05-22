import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ActivityResults5 extends Activity {

    Button button, submitButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences= getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String oResult = getResources().getString(R.string.resultsO) + sharedPreferences.getString("facet1", "Default");

        LinearLayout activityResults5= new LinearLayout(this);
        TextView tvO=new TextView(this);
        Button b=new Button(this);

        LayoutParams dimensions= new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        activityResults5.setLayoutParams(dimensions);

        LayoutParams viewDimensions= new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        tvO.setLayoutParams(viewDimensions);
        b.setLayoutParams(viewDimensions);


        activityResults5.setOrientation(LinearLayout.VERTICAL);
        tvO.setText(oResult);
        b.setText("Button here");

        activityResults5.addView(tvO);
        activityResults5.addView(b);

        setContentView(activityResults5);

    }

}