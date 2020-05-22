import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
@SuppressLint("NewApi")
public class FragButton1 extends Fragment{

    TextView tv;
public FragButton1(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragbutton1, container, false);
        String strtext=getArguments().getString("name1");
        tv=(TextView)rootView.findViewById(R.id.tv_times1);
        tv.setText(strtext);

        return rootView;
    }

}