@Override
public void onViewCreated(View view, Bundle savedInstanceState) {
   super.onViewCreated(view, savedInstanceState);

   String dateText = (savedInstanceState != null) ? 
          savedInstanceState.getString("DATE_TEXT") :
          DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

   date = (TextView) view.findViewById(R.id.textDate);
   date.setText(DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime()));
}