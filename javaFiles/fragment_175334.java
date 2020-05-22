@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.your_layout, container, false);        
    String driverData = readFileFromSDCard(); 
    String driverArray[] = driverData.split(";"); 
    txtName = (TextView) view.findViewById(R.id.txtName); 
    txtName.setText("Andrew");

}