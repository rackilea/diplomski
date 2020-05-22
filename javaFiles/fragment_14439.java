public class MyFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sandbox, container, false);
        Button button = (Button) v.findViewById(R.id.button);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                DialogFragment newFragment = PagerDialog.newInstance();
                newFragment.show(getChildFragmentManager(), "dialog");
            }

        });

        return v;
    }
}