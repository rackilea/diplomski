@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_calendar, container, false);

    cal = (CalendarView) v.findViewById(R.id.calendarView);
    date = cal.getDate();

    cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
        @Override
        public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
            if(cal.getDate() != date) {
                date = cal.getDate();
                Toast.makeText(view.getContext(), "Year=" + year + " Month=" + month + " Day=" + dayOfMonth, Toast.LENGTH_LONG).show();
                //cal.setBackgroundColor(Color.RED);
            }
        }
    });

    // Inflate the layout for this fragment
    return v;
}