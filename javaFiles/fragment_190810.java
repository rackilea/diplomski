import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;


public class MainActivity extends Activity implements OnClickListener{
Button btn1,btn2;
int click1=0,click2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }
    @SuppressLint("NewApi")
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        Fragment fragment = null;
         if (v == btn1) {
                // do stuff for button left
             click1++;

             Bundle bundle=new Bundle();
                String clickstring1=Integer.toString(click1);
                 bundle.putString("name1",clickstring1 );

             fragment = new FragButton1();


                    fragment.setArguments(bundle);


            }
         if (v == btn2) {
                // do stuff for button right
             click2++;
             Bundle bundle=new Bundle();
                String clickstring2=Integer.toString(click2);
             bundle.putString("name2",clickstring2 );
                fragment = new FragButton2();
                fragment.setArguments(bundle);
            }

         if (fragment != null) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_container, fragment).commit();
         }
         else{
             Log.e("MainActivity", "Error in creating fragment");
         }

    }



}