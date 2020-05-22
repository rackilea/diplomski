import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("NewApi")
public class FragButton2 extends Fragment{

    TextView tv2;
public FragButton2(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragbutton2, container, false);
        tv2=(TextView)rootView.findViewById(R.id.tv_times2);
        String strtext=getArguments().getString("name2");
        tv2.setText(strtext);
        return rootView;
    }


}