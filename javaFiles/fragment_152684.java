public abstract class LoginFragment extends Fragment {

MediaPlayer clickPlayer;
int layoutId;
View view;
OnButtonListener buttonCallback;

@Nullable
@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    view = inflater.inflate(layoutId, container, false);

    return view;

}

public interface OnButtonListener {
    void onButtonSelected(LoginFragment fragment);
}

@Override
public void onAttach(Context context) {
    super.onAttach(context);

    try {
        buttonCallback = (OnButtonListener) context;
    } catch (ClassCastException e) {
        throw new ClassCastException(context.toString()
                + " must implement OnButtonListener");
    }

}

public MyButton setUpButton(int buttonId) {

    final MyButton button = (MyButton) view.findViewById(buttonId);
    View.OnClickListener authHelpListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            clickPlayer = MediaPlayer.create(getContext(), R.raw.click);
            clickPlayer.start();
            LoginFragment newFragment = determineFragment(button);
            buttonCallback.onButtonSelected(newFragment);
        }
    };
    button.setOnClickListener(authHelpListener);

    return button;

}

public LoginFragment determineFragment(MyButton button) {

    LoginFragment result;
    int buttonId = button.getId();

    switch (buttonId){

        case R.id.auth_help_button:
            result = new HelpFragment();
            break;
        case R.id.agr_cancel_button:case R.id.help_cancel_button:
        case R.id.reg_cancel_button:case R.id.reg_cont_cancel_button:
            result = new AuthFragment();
            break;
        case R.id.agr_back_button:case R.id.reg_cont_button:
            result = new RegContFragment();
            break;
        case R.id.reg_cont_agr_button:
            result = new AgrFragment();
            break;
        case R.id.auth_reg_button:
            result = new RegFragment();
            break;
        default:
            result = null;
            break;
    }

    return result;

}