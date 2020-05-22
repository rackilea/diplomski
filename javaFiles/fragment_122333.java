@Override
public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
    View v = inflater.inflate(R.layout.reminder_edit, null);
    mTimeButton = (Button) v.findViewById(R.id.reminder_time); 
    return v;
}