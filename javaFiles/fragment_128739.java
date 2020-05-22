import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends Activity {



    Button fb;

    private CallbackManager callbackManager;
    private LoginManager loginManager;
    private List<String> permissionNeeds= Arrays.asList("user_photos", "email", "user_birthday", "user_friends");
    private String fbUserId;
    private String fbUserName;
    private String fbEmail;
    private String fbGender;
    private String fbDob;
    TextView txt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this);
        callbackManager = CallbackManager.Factory.create();
        loginManager = LoginManager.getInstance();

        setContentView(R.layout.activity_main);
        fb = (Button)findViewById(R.id.button);
        txt=  (TextView)findViewById(R.id.txt);








    }
    public void onClick(View v) {
       /* if (v == fb) {
            loginButton.performClick();
        }*/
        FaceBookLogin();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);

    }




    private void FaceBookLogin() {
        loginManager.logInWithReadPermissions(MainActivity.this, permissionNeeds);
        loginManager.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(
                                    JSONObject object,
                                    GraphResponse response) {

                                Log.v("LoginActivity", response.toString());


                                try {
                                    fbUserId = object.getString("id");
                                    fbUserName = object.getString("name");
                                    fbEmail = object.getString("email");
                                    fbGender = object.getString("gender");
                                    fbDob = object.getString("birthday");

                                    txt.setText(object.toString());

                                    if (fbUserName.contains(" ")) {
                                        String first_name = fbUserName.substring(0, fbUserName.indexOf(' '));
                                        String lastName = fbUserName.substring(fbUserName.indexOf(' ') + 1);


                                    } else {
                                       // first_name = fbUserName;
                                        //lastName = " ";
                                    }
                                    if (fbEmail != null) {
                                       // SendValueToServer(fbUserName, first_name, lastName, fbEmail);
                                        Toast.makeText(getApplicationContext(),"fbEmail"+fbEmail,Toast.LENGTH_SHORT).show();
                                    } else {
                                       // SendValueToServer(fbUserName, first_name, lastName, " ");
                                        Toast.makeText(getApplicationContext(),"fbEmail:"+"blank",Toast.LENGTH_SHORT).show();
                                    }


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender,birthday");
                request.setParameters(parameters);
                request.executeAsync();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException e) {

            }
        });


    }



}