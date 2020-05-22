public void onClick(View v) {
  if(rowlist.size() > 0)
  {
     table.addView(rowlist.get(0));
     rowlist.remove(0);
  }
}