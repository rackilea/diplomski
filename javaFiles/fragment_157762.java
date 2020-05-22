@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ((DemoBaseActivity) getActivity()).inject(this);
}