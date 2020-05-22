@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState)
{
    final View rootView = inflater.inflate(R.layout.activity_doctor_login, container, false);
    url ="jdbc:mysql://"+MainActivity.ip+":3306/mediapp";  //getting value from mainactivity ip value