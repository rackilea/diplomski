for (int j = 0; j < size; j++)
{
    StatZoneItem statZoneItem = grandTotalStatsRespond.getStatZoneItems().get(j);
    LinearLayout l = (LinearLayout) inflater.inflate(R.layout.loader_total_stat_item, null);

    // Here I need to find TableRow and TextView with LinearLayout  by its ID

      TableRow  tableRow = l.findViewById(R.id.tableRowID);
      TextView  textView = l.findViewById(R.id.textViewID);
      textView.setText("NILESH");
    // and set values from  statZoneItem object.                   

    root.addView(l);
}