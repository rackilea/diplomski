@Nullable
@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.pager_layout, container, false);
    return view;
}

TextView tv;

@Override
public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    tv = (TextView) view.findViewById(R.id.textDes);
    tv.setText("text to set dynamically");
    ...
}