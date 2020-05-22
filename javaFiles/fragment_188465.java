@Nullable
@Override
public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.frag2_layout, container, false);

    Spinner spinner = view.findViewById(R.id.spinner1);
    ...

    return view; // after finishing all logic.
}