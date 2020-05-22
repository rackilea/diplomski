mReadingLog  = (ListView) view.findViewById(R.id.scanLogView);
//mReadingLog.setMovementMethod(new ScrollingMovementMethod());//8/31
//mReadingLog.setText(readFromFile());//8/31

adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, listItems); //9/11/17
mReadingLog.setAdapter(adapter);  //9/11/17
mPresence = (Button) view.findViewById(R.id.button_present);