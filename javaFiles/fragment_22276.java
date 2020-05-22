public class Login extends Activity implements OnClickListener {

    Configuration cfg;
    String ip;
    String port;
    private String LOGIN_URL;
    //other variables

    protected void onCreate(Bundle savedInstanceState) {
        //here you initialize your variables
        try {
            cfg = new Configuration();
            String[] params = cfg.getparams();
            ip = params[0];
            port = params[1];
            LOGIN_URL = "http://"+ ip +":"+port+"/webservice/login.php";
        } catch (IOException e) {
            //handle the exception
        }
        //.. your other code ...
    }
    //... your other methods ...

   }