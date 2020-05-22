//Home Activity 
    //implemet View.OnClickListener  , it is working

  import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInFragment extends Fragment implements View.OnClickListener {

private static final String TAG = "SignInFragment";

private TextView mEmail, mPassword, mHeading, mToRegister, mFckyou;
private EditText eEmail, ePassword;
private Button btnSignin;
private ProgressBar mProgressBar;

//Firebase
private FirebaseAuth mAuth;
private FirebaseAuth.AuthStateListener mAuthListener;
@Nullable
@Override
public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.signin_fragment, container, false);

    //TextView
    mEmail = view.findViewById(R.id.tvEmail);
    mPassword = view.findViewById(R.id.tvPassword);
    mHeading = view.findViewById(R.id.heading);
    mToRegister = view.findViewById(R.id.tvToRegister);
    mFckyou = view.findViewById(R.id.fckyou);
    //EditText
    mEmail = view.findViewById(R.id.etEmail);
    ePassword = view.findViewById(R.id.etPassword);
    //Button
    btnSignin = view.findViewById(R.id.btnSignin);
    //ProgressBar
    mProgressBar = view.findViewById(R.id.progressBar);

    //Progress Bar and Text view = GONE
    mProgressBar.setVisibility(View.GONE);
    mFckyou.setVisibility(View.GONE);
    mToRegister.setOnClickListener(this);

    setupFirebaseAuth();
    signInUser();

    return view;
}

public void navigateToReigster(){

   Fragment fragment = new RegisterFragment();
    FragmentManager fragmentManager = getSupportFragmentManager();
    fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.replace(R.id.container, fragment).commit();



    });

}
  @Override
    public void onClick(View vv) {
        if (vv == mToRegister) {
         navigateToReigster();
        }
        }

private boolean isStringNull(String string){

    if (string.equals("")){
        return true;
    }

    return false;
}

    /*
---------------------------------Firebase-----------------------------------
 */


private void signInUser(){
    // Button = to sign in the user.
    btnSignin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String email = eEmail.getText().toString();
            String password = ePassword.getText().toString();

            if (isStringNull(email) && isStringNull(password)){

                Toast.makeText(getActivity(), "You must field out all the fields.", Toast.LENGTH_SHORT).show();
            }else {

                //Progress Bar and TextView be visible
                mProgressBar.setVisibility(View.VISIBLE);
                mFckyou.setVisibility(View.VISIBLE);

                //To sign in users
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()){
                                    Toast.makeText(getActivity(), "Sign in Successful!", Toast.LENGTH_SHORT).show();

                                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                                    ft.replace(R.id.container, new HomeActivity());
                                    ft.commit();


                                }else {
                                    //Progress bar and Text View will be GONE. So the users can try again.
                                    mProgressBar.setVisibility(View.GONE);
                                    mFckyou.setVisibility(View.GONE);
                                    Toast.makeText(getActivity(), "Could not sign in. Please try again.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }

        }
    });


}