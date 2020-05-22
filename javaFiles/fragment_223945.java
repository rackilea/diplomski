import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class T3_TrampetFragment extends Fragment  implements View.OnClickListener {


ImageButton BtnRMinus, BtnRPlus, BtnPMinus, BtnPPlus, BtnSMinus, BtnSPlus, BtnTMinus, BtnTPlus;
EditText R_num, P_num, S_num, T_num, Result_num;
int R_counter = (1);
int P_counter, S_counter = (0);
double T_counter = (0.0);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.t3_trampetlayout, container, false);



    R_num = (EditText) view.findViewById(R.id.Rnum);
    P_num = (EditText) view.findViewById(R.id.Pnum);
    S_num = (EditText) view.findViewById(R.id.Snum);
    T_num = (EditText) view.findViewById(R.id.Tnum);
    Result_num = (EditText) view.findViewById(R.id.Resultnum);

    BtnRMinus = (ImageButton) view.findViewById(R.id.btn_r_minus);
    BtnRPlus = (ImageButton)view.findViewById(R.id.btn_r_plus);
    BtnPMinus = (ImageButton) view.findViewById(R.id.btn_p_minus);
    BtnPPlus = (ImageButton) view.findViewById(R.id.btn_p_plus);
    BtnSMinus = (ImageButton) view.findViewById(R.id.btn_s_minus);
    BtnSPlus = (ImageButton) view.findViewById(R.id.btn_s_plus);
    BtnTMinus = (ImageButton) view.findViewById(R.id.btn_t_minus);
    BtnTPlus = (ImageButton) view.findViewById(R.id.btn_t_plus);

    BtnRMinus.setOnClickListener(this);
    BtnRPlus.setOnClickListener(this);
    BtnPMinus.setOnClickListener(this);
    BtnPPlus.setOnClickListener(this);
    BtnSMinus.setOnClickListener(this);
    BtnSPlus.setOnClickListener(this);
    BtnTMinus.setOnClickListener(this);
    BtnTPlus.setOnClickListener(this);

  return view;
}

@Override
public void onClick(View v) {
    switch (v.getId()) {
        case R.id.btn_r_minus:

            if (R_counter > 1) {
                --R_counter;
                R_num.setText(String.valueOf(R_counter));
            }

            break;
        case R.id.btn_r_plus:

            if (R_counter < 3) {
                ++R_counter;
                R_num.setText(String.valueOf(R_counter));
            }

            break;
        case R.id.btn_p_minus:

            if (P_counter > 0) {
                --P_counter;
                P_num.setText(String.valueOf(P_counter));
            }

            break;
        case R.id.btn_p_plus:

            if (P_counter < 3) {
                ++P_counter;
                P_num.setText(String.valueOf(P_counter));
            }

            break;
        case R.id.btn_s_minus:

            if (S_counter > 0) {
                --S_counter;
                S_num.setText(String.valueOf(S_counter));
            }

            break;
        case R.id.btn_s_plus:

            if (S_counter < 3) {
                ++S_counter;
                S_num.setText(String.valueOf(S_counter));
            }

            break;
        case R.id.btn_t_minus:

            if (T_counter > 0) {
                T_counter = (T_counter - 0.5);
                T_num.setText(String.valueOf(T_counter));
            }

            break;
        case R.id.btn_t_plus:

            if (T_counter < 5.5) {
                T_counter = (T_counter + 0.5);
                T_num.setText(String.valueOf(T_counter));
            }

            break;
        default:
            break;
      }
    }
}