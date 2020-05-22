@Override 
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.your_fragment, container, false);
        ButterKnife.bind(this, view);
        // TODO Use fields...
        return view;
      }
}