public class SayHelloFragment extends Fragment {

    private String mText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.say_hello_layout, container);
        final TextView text = (TextView) view.findViewById(R.id.textView1);
        if (mText != null)
            text.setText(mText);

        view.findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mText = "Hello!";
                text.setText(mText);
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
    }

}