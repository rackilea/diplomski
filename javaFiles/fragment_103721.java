public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        Button login = (Button) findViewById(R.id.loginbutton);
        TextView signup = (TextView) findViewById(R.id.signup);

        EditText email1 = (EditText) findViewById(R.id.Email);
        EditText password1 = (EditText) findViewById(R.id.Password);


        if (signup != null) {
            signup.setOnClickListener(new TextView.OnClickListener() {
                                          public void onClick(View V) {
                                              showAdminacesslayout();

                                          }
                                      }
            );
        }

        LinearLayout adminacesslayout = (LinearLayout) findViewById(R.id.adminaccesslayout);
        int visibility1 = adminacesslayout.getVisibility(); //        if(visibility1==View.VISIBLE) //        { // //            Button
adminlogin = (Button) findViewById(R.id.adminpassbutton); // //     
if (adminlogin != null) { //               
adminlogin.setOnClickListener(new Button.OnClickListener(){ //      
public void onClick(View V){ //                                     
EditText adminpass= (EditText) findViewById(R.id.admiinpass); //    
String adminpasswordtyped= adminpass.getText().toString(); // //    
//       if("1234".equals(adminpasswordtyped)) //                   
//        {   LinearLayout adminacesslayout= (LinearLayout)
findViewById(R.id.adminaccesslayout) ; //                           
//            adminacesslayout.setVisibility(View.GONE); //         
//        } //                                                     
RelativeLayout signuplayout= (RelativeLayout)
findViewById(R.id.signup_layout); //                                
int visibility2=signuplayout.getVisibility(); //                    
if(visibility2==View.GONE) //                                       
{ //                                                         
LinearLayout adminacesslayout= (LinearLayout)
findViewById(R.id.adminaccesslayout) ; //                           
adminacesslayout.setVisibility(View.GONE); //                       
signuplayout.setVisibility(View.VISIBLE); //                        
} // // //                                                  } // // 
} // //                ); //            } //        }


        login.setOnClickListener(new Button.OnClickListener() {
                                     public void onClick(View V) {
                                         checkdetails();
                                     }

                                 }
        );
    }

    private void showAdminacesslayout() {

        Button login = (Button) findViewById(R.id.loginbutton);
        login.setVisibility(View.INVISIBLE);
        LinearLayout adminacesslayout = (LinearLayout) findViewById(R.id.adminaccesslayout);
        int visibility = adminacesslayout.getVisibility();

        if (visibility == View.GONE) {
            adminacesslayout.setVisibility(View.VISIBLE);
        }

        Button adminlogin = (Button) findViewById(R.id.adminpassbutton);

        if (adminlogin != null) {
            adminlogin.setOnClickListener(new Button.OnClickListener() {
                                              public void onClick(View V) {
                                                  EditText adminpass = (EditText) findViewById(R.id.admiinpass);
                                                  String adminpasswordtyped = adminpass.getText().toString();

                                                  //       if("1234".equals(adminpasswordtyped))
                                                  //        {   LinearLayout adminacesslayout= (LinearLayout)
findViewById(R.id.adminaccesslayout) ;
                                                  //            adminacesslayout.setVisibility(View.GONE);
                                                  //        }
                                                  RelativeLayout signuplayout = (RelativeLayout) findViewById(R.id.signup_layout);
                                                  int visibility2 = signuplayout.getVisibility();
                                                  if (visibility2 == View.GONE) {
                                                      LinearLayout adminacesslayout = (LinearLayout)
findViewById(R.id.adminaccesslayout);
                                                      adminacesslayout.setVisibility(View.GONE);
                                                      signuplayout.setVisibility(View.VISIBLE);
                                                  }


                                              }

                                          }

            );
        }
    }

    public void checkdetails() {
        EditText email = (EditText) findViewById(R.id.Email);
        EditText password = (EditText) findViewById(R.id.Password);
        String emailtyped = email.getText().toString();
        String passwordtyped = password.getText().toString();
        String filename = "my file";


        //Writing to file section
        String string = "Hello world!";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(emailtyped.getBytes());
            outputStream.write("\r\n".getBytes());
            outputStream.write(passwordtyped.getBytes());
            outputStream.close();
            Context context = getApplicationContext();
            CharSequence text = "Login history Saved";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }


        //Reading from file section Text

        if ("ciao".equals(emailtyped)) { //        if (getString(R.string.firstemailtyped).equals(emailtyped)) {
            if ("1234".equals(passwordtyped)) {
                Button loogin = (Button) findViewById(R.id.loginbutton);
                TextView dummydata = (TextView) findViewById(R.id.dummydata);


                // After that, you can call read method to read one character at a time from the file and then you can print it. Its
syntax is given below −

                try {
                    InputStream inputStream = openFileInput("my file");

                    if (inputStream != null) {
                        InputStreamReader streamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(streamReader);

                        String l;
                        String k = "";

                        while ((l = bufferedReader.readLine()) != null) {
                            // do what you want with the line
                            k = (k + l);
                            dummydata.setText(k);
                        }

                    }

                    inputStream.close(); //close the file
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }
    }


}