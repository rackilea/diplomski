public class NetRr extends MainActivity implements View.OnClickListener
{
float f1=0f,f2=0f,f3=0f,f4=0f,f5=0f;
String s1="",s2="",s3="",s4="",s5="";
public EditText NetrrRS,NetrrOF,NetrrRC,NetrrOB;
public Button NetrrCAL,NetrrRES;
public TextView NetrrTV;
@Override
protected void onCreate(Bundle savedInstanceState)
 {
super.onCreate(savedInstanceState);
setContentView(R.layout.net_rr);

NetrrCAL=(Button)findViewById(R.id.NetrrCAL);
NetrrRES=(Button)findViewById(R.id.NetrrRES);
NetrrRS= (EditText)findViewById(R.id.NetrrRS);

NetrrCAL.setOnClickListener(this);
NetrrRES.setOnClickListener(this);
}


@Override
public void onClick(View v)
{
switch(v.getId())
{
    case R.id.NetrrCAL:
       sUsername = NetrrRS.getText().toString();
//checks the edit text is empty or not
         if (sUsername.matches("")) {
//if empty set yout text
             NetrrRS.setText("Your Text");
           }
        break;

    case R.id.NetrrRES:
             //same approach follows as above
        break;
}

 }

}