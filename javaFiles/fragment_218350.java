public class FragmentTwo extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag2,container,false);
        TextView tv1 = (TextView) rootView.findViewById(R.id.textView1);
        String text = getArguments().getString("key");
        tv1.append(text);
        return rootView;
    }   
}