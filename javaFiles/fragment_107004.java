@Override
public void onItemClick(AdapterView<?> a, View row, int position, long id) { 
   // solution with list of positions:
   myAdapterClass.addPosition(position);

  // solution with property
  myAdapteClass.setItemClicked(position);

  // update immediate after click row
  ((TextView) row.findViewById(R.id.yourTextViewId)).setText("Accepted");
}