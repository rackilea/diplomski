public class MainActivityTwo extends FragmentActivity
{

    FragmentManager objFrgMng=getSupportFragmentManager();
    FragmentTransaction objFrgTrns;
    FragmentTwo objFrgTwo=new FragmentTwo();
    String recievedData;
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act_two_container);

        Bundle extras=getIntent().getExtras();
        recievedData=extras.getString("key");

        Log.d("RECIEVED-DATA", recievedData);

        //sending data to second fragment in second activity
        Bundle bundle = new Bundle();
        bundle.putString("edttext", recievedData);
        objFrgTwo.setArguments(bundle);


        getSupportFragmentManager().beginTransaction().add(R.id.mainActTwoContainerId,objFrgTwo, "MainActFrgTwoTag").commit();


    }

}