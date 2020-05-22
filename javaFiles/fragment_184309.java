public class ActivityNeki extends FragmentActivity implements DatePickerDialog.OnDateSetListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        Fragment fragment = getSupportFragmentManager().findFragmentByTag( "my_dialog_tag" );

        if( fragment != null )
        {
            ( (MyDialogFragment) fragment ).listener = this;
        }
    }

    // Called from xml
    public void onClickOpenDPD(View view)
    {    
       MyDialogFragment.newInstance( x, x, x, this ).show( getSupportFragmentManager(), "my_dialog_tag" );
    }

    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
    {
        // Do your crazy callback stuff
    }
}