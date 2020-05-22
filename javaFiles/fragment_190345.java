tableLayout = (TableLayout) getActivity().findViewById(R.id.ourTable);
if(tableLayout != null ){
tableRow = (TableRow) tableLayout.getChildAt(1);
id0Count = (TextView) tableRow.getChildAt(0);
tableRow = (TableRow) tableLayout.getChildAt(2);
id1Count = (TextView) tableRow.getChildAt(0);
tableRow = (TableRow) tableLayout.getChildAt(3);
id2Count = (TextView) tableRow.getChildAt(0);
tableRow = (TableRow) tableLayout.getChildAt(4);
id3Count = (TextView) tableRow.getChildAt(0);
tableRow = (TableRow) tableLayout.getChildAt(5);
id4Count = (TextView) tableRow.getChildAt(0);
MainActivity.CountZ1= getActivity().getSharedPreferences(MainActivity.zekr1,0);
MainActivity.CountZ2 = getActivity().getSharedPreferences(MainActivity.zekr2,0);
MainActivity.CountZ3 = getActivity().getSharedPreferences(MainActivity.zekr3,0);
MainActivity.CountZ4 = getActivity().getSharedPreferences(MainActivity.zekr4,0);
MainActivity.CountZ5 = getActivity().getSharedPreferences(MainActivity.zekr5,0);
id0Count.setText(""+MainActivity.CountZ1.getInt(MainActivity.zekr1,0));
id1Count.setText(""+MainActivity.CountZ2.getInt(MainActivity.zekr2,0));
id2Count.setText(""+MainActivity.CountZ3.getInt(MainActivity.zekr3,0));
id3Count.setText(""+MainActivity.CountZ4.getInt(MainActivity.zekr4,0));
id3Count.setText(""+MainActivity.CountZ5.getInt(MainActivity.zekr5,0));

}