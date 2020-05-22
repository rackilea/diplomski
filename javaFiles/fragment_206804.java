public class question1from10 extends Fragment implements View.OnClickListener {

    public question1from10() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_question1from10, container, false);

        // Set the onClick for each of our views as the one implemented by this Fragment
        rootView.findViewById(R.id.test1from10question1answerA).setOnClickListener(this);
        rootView.findViewById(R.id.test1from10question1answerB).setOnClickListener(this);
        rootView.findViewById(R.id.test1from10question1answerC).setOnClickListener(this);
        ...

        return rootView;
    }

    @Override
    public void onClick(View view) {

        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()){

            case R.id.test1from10question1answerA:
                Toast.makeText(getActivity(), "A", Toast.LENGTH_LONG ).show();

            case R.id.test1from10question1answerB:
                Toast.makeText(getActivity(), "B", Toast.LENGTH_LONG ).show();

            case R.id.test1from10question1answerC:
                Toast.makeText(getActivity(), "C", Toast.LENGTH_LONG ).show();
        }
    }
}