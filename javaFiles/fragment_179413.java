public class SearchMobileFragment extends DialogFragment implements View.OnClickListener{

    private OnMobileNumberSelectedListener onMobileNumberSelectedListener;

    EditText mMobileNumberEditText;
    Button mSearchButton;

    public SearchMobileFragment() {
        // Required empty public constructor
    }

    public static SearchMobileFragment newInstance(OnMobileNumberSelectedListener callback) {
        SearchMobileFragment searchMobileFragment = new SearchMobileFragment();
        searchMobileFragment.initialize(callback);
        return searchMobileFragment;
    }

    public void initialize(OnMobileNumberSelectedListener callback) {
        onMobileNumberSelectedListener = callback;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_search_mobile, container, false);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        mMobileNumberEditText = (EditText) root.findViewById(R.id.mobile_number_editText);
        mSearchButton = (Button) root.findViewById(R.id.search_button);
        mSearchButton.setOnClickListener(this);
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() == null)
            return;
        getDialog().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    public void setOnMobileNumberSelectedListener(OnMobileNumberSelectedListener callback) {
        this.onMobileNumberSelectedListener = callback;
    }

    @Override
    public void onClick(View v) {
        dismiss();


        onMobileNumberSelectedListener.onMobileNumberSelected(mMobileNumberEditText.getText().toString());

    }



    public interface OnMobileNumberSelectedListener {
        void onMobileNumberSelected(String mobileNumber);
    }
}