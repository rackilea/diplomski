import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.app.Activity;

public class InputActivity extends Activity {

    Fragment fragment;
    Button btn1, btn2, btn3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.to_do_list);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);

        android.app.FragmentManager fm = getFragmentManager(); 
        android.app.FragmentTransaction ft = fm.beginTransaction();

        StartFragment myFragment = new StartFragment();
        ft.add(myFragment,R.id.myFragment);  
        ft.commit();

        btn1.setOnClickListener(btnOnClickListener);
        btn2.setOnClickListener(btnOnClickListener);

    }

    Button.OnClickListener btnOnClickListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {

            Fragment newFragment;

            if (v == btn1)
                newFragment = new Fragment1();
            else if (v == btn2)
                newFragment = new Fragment2();
            else
                newFragment = new StartFragment();

            android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();

            transaction.replace(R.id.myFragment, newFragment);
            transaction.addToBackStack(null);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.commit();

        } 
    };
}