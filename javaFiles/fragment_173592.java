public static FooFragment newInstance()
{
    return new FooFragment();
}

@Override
public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
{
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_layout, container, false);

    // work with your ui code here.
    return view;
}