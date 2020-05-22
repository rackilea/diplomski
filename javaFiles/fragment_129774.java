public class FragmentX extends Fragment {
    public static FragmentX newInstance(Param1 param1, Param2 param2) {
        FragmentX fragment = new FragmentX();
        Bundle args = new Bundle();
        args.putXXX(key1, param1);
        args.putXXX(key2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Param1 param1 = getArguments().getXXX(key1);
            Param2 param2 = getArguments().getXXX(key2);
            ...
        }
    }

    ...
}