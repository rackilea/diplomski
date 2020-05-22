public class TestFrag extends SherlockFragment {
    Integer intPageNum;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null)
            intPageNum = args.getInt("num");
        else
            intPageNum = 1;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_test, container, false);
        TextView tv = (TextView) v.findViewById(R.id.textView1);
        tv.setText("Page " + intPageNum.toString());
        return v;
    }
}