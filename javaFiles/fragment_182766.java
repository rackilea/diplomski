public class ProfileFragment extends Fragment {
    private SharedPrefs sharedPrefs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                     Bundle savedInstanceState) {
    sharedPrefs=new SharedPrefs(getActivity());
    View view = inflater.inflate(R.layout.fragment_profile, null);
    TextView userName=view.findViewById(R.id.userName);
    String a=sharedPrefs.getLogedInKey();
    userName.setText(a);

      return view;
    }
    @Override

    public void onViewCreated(@NonNull View view, @Nullable Bundle                  
    savedInstanceState) {
   super.onViewCreated(view, savedInstanceState);

   }}