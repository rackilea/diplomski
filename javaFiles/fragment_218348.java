public class FragmentOne extends Fragment {

    public interface ReturnData
    {
        public void sendData(String result);
    }

    ReturnData mCallback;
     @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);

            // This makes sure that the container activity has implemented
            // the callback interface. If not, it throws an exception
            try {
                mCallback = (ReturnData) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString()
                        + " must implement ReturnData");
            }
        }
    TextView tv2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag1,container,false);
        tv2 = (TextView) rootView.findViewById(R.id.textView2);
        Button b= (Button) rootView.findViewById(R.id.button1);
        b.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mCallback.sendData(tv2.getText().toString());
            }

        });
        return rootView;
    }   
}