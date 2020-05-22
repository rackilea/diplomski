public class MainActivity extends Activity implements ReturnData{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentOne newFragment = new FragmentOne();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    @Override
    public void sendData(String result) {
        // TODO Auto-generated method stub
        FragmentTwo newFragment = new FragmentTwo();
        Bundle args = new Bundle();
        args.putString("key",result);
        newFragment.setArguments(args);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

}