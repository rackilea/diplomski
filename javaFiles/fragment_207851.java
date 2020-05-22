JList<String> list = new JList<String>( ... );
list.setLayoutOrientation(JList.VERTICAL_WRAP);
list.setVisibleRowCount(1);
JScrollPane scrollPane = new JScrollPane( list );
scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
frame.add( scrollPane );