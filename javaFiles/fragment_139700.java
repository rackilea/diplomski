public class Fragment_main extends Fragment {

    public Fragment_main() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main,container,false);
        Button button_inditas = (Button)rootView.findViewById(R.id.button_inditas);
        button_inditas.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

         FragmentManager fragmentManager = getFragmentManager ();
         FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction ();

         fragmentTransaction.add (R.id.content_frame, new Fragment_1());
         fragmentTransaction.commit ();


        });
    return rootView;

    }
}