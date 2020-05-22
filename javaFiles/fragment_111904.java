View header = (View)getLayoutInflater().inflate(R.layout.list_header_layout, null);
    TextView headerValue = (TextView) header.findViewById(R.id.list_header);
    headerValue.setText( this.getString(R.string.headerSupervise) );

    listView.addHeaderView(header);
    listView.setAdapter(adapter);