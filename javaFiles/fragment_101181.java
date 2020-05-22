public class BaseActivity extends AppCompatActivity{

    public void showNoInternetMessage(View view){
     Snackbar.make(view, "Your You are not Connected to the internet",
                        Snackbar.LENGTH_LONG)
                        .setAction("Action", null).setActionTextColor(Color.RED).show();
                Log.i("TRUE","User is not connected");
    }
    }