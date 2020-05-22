public class FormFragment extends Fragment {

    private static final String TAG = FormFragment.class.getSimpleName();

    private static final int REQUEST_CODE_INSPECDATENEW = 200;
    private static final int REQUEST_CODE_LASTINSPECDATE = 201;

    private EditText editText_date;
    private EditText editText_prevDate;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank2, container, false);
    }

    //get Date func
    public void showDatePickerDialog(View v, int requestCode) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.setTargetFragment(this, requestCode);
        newFragment.show(getFragmentManager(), "datePicker");
    }

    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //inspection date
        editText_date = view.findViewById(R.id.input_inspecDateNew);
        editText_date.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //get current text
                    showDatePickerDialog(v, REQUEST_CODE_INSPECDATENEW);
                }
            }
        });

        //previous inspection date
        editText_prevDate = view.findViewById(R.id.input_lastInspecDate);
        editText_prevDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //get current text
                    showDatePickerDialog(v, REQUEST_CODE_LASTINSPECDATE);
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG, "onActivityResult: ");

        if (resultCode == Activity.RESULT_OK) {
            if (data == null) {
                return;
            }

            String dataValue = data.getStringExtra("value");

            if (requestCode == REQUEST_CODE_INSPECDATENEW) {
                editText_date.setText(dataValue);
            } else if (requestCode == REQUEST_CODE_LASTINSPECDATE) {
                editText_prevDate.setText(dataValue);
            }
        }
    }
}