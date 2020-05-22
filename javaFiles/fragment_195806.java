public class YourFragment extends Fragment implements OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.your_fragment, container, false);
    Button btn = (Button) rootView.findViewById(R.id.new_button);
    btn.setOnClickListener(this);
 return rootView;
}

@Override
   public void onClick(View v) {
    switch (v.getId()) {
    case R.id.new_button:

       //
  Intent intent = new Intent(getActivity(), GameActivity.class);
  getActivity().startActivity(intent);

        break;
    }
}