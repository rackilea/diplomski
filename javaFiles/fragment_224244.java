EditText ediText1;
 @Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    // TODO Auto-generated method stub
     View v = inflater.inflate(R.layout.fragmentlayout, container, false);
              editText1 = (EditText) v.findViewById (R.id.editText1);
    return v;
}