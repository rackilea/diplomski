public class MainActivity extends AppCompatActivity implements AddEmployeesDialogFragment.DialogListener{

//other code here...

    @Override
    public void onNeutralClick(DialogFragment dialog, int val) {
        regionValue[4] = (new Integer(val)).toString();
    }

}