public class Register extends AppCompatActivity {

    private TextInputLayout textInputRegPassword;
    private TextInputLayout textInputRegCfmPassword;
    private TextInputEditText inputRegCfmPassword;
    private TextInputEditText inputRegPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();

        setContentView(R.layout.activity_register);

        textInputRegPassword = (TextInputLayout)findViewById(R.id.text_input_RegPassword);
        textInputRegCfmPassword =(TextInputLayout) findViewById(R.id.text_input_RegCfmPassword);
        inputRegCfmPassword =(TextInputEditText) findViewById(R.id.input_RegCfmPassword);
        inputRegPassword =(TextInputEditText) findViewById(R.id.input_RegPassword);
    }

    private boolean RegisterPassword(){
        String userReg = inputRegPassword.getText().toString().trim();

        if(userReg.isEmpty()){
            textInputRegPassword.setError("Enter Password");
            return false;
        } else {
            textInputRegPassword.setError(null);
            return true;
        }
    }

    private boolean RegisterCfmPassword(){
        String userReg = inputRegCfmPassword.getText().toString().trim();

        if(userReg.isEmpty()){
            textInputRegCfmPassword.setError("Enter Password");
            return false;
        } else {
            textInputRegCfmPassword.setError(null);
            return true;
        }
    }

    private boolean Verify(){

        if(inputRegPassword.getText().toString().equals(inputRegCfmPassword.getText().toString())){
            return true;
        } else{
            textInputRegCfmPassword.setError("Password Do Not Match");
            return false;
        }
    }

    public void Reg(View v){
        if(!RegisterPassword() || !RegisterCfmPassword() || !Verify() ){
            return;
        }
    }   
}