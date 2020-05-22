@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.page_two, container, false);
    RadioButton levelbtn = (RadioButton) v.findViewById(R.id.radioextreme); 
    levelbtn.setChecked(true);
    return v;
}