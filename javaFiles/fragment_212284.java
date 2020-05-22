public static DialogFrag newInstance(FragCallback callback) {
    Bundle bundle = new Bundle();
    bundle.putSerializable("FragCallback", callback);
    DialogFrag dialog = new DialogFrag();
    dialog.setArguments(bundle);
    return dialog;
}

@Nullable
@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.filter_popup, container, false);
}
...
@Override
public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    this.callback = (FragCallback) getArguments().getSerializable("FragCallback");
    min = (EditText) view.findViewById(R.id.et_filterMinPrice);
    max = (EditText) view.findViewById(R.id.et_filterMaxPrice);
    customButton = (Button) view.findViewById(R.id.custom_button); // the button in your layout
    customButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            callback.filter(min.getText().toString(),min.getText().toString());
        }
    });
}