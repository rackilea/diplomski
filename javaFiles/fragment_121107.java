class CustomAdapter extends SimpleCursorAdapter {

    @SuppressWarnings("deprecation")
    public CustomAdapter(Context context, int layout, Cursor c, String[] from, int[] to) {
        super(context, layout, c, from, to);
        // TODO Auto-generated constructor stub
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor){
        int row_id = cursor.getColumnIndex("_id");  //Your row id (might need to replace)
        TextView tv = (TextView) view.findViewById(R.id.text1);
        final TextView tv1 = (TextView) view.findViewById(R.id.text2);
        int col1 = cursor.getColumnIndex("title");
        String title = cursor.getString(col1 );
        int col2 = cursor.getColumnIndex("content");
        final String content = cursor.getString(col2 );
        //  TextView tv2 = (TextView) view.findViewById(R.id.text3);
        // cursor.getColumnName(1)
        tv.setText( title);
        tv1.setText( content);
        // tv2.setText( ""+cursor.getColumnIndex(GinfyDbAdapter.CATEGORY_COLUMN_COUNT));
        // String[] from = new String[]{GinfyDbAdapter.CATEGORY_COLUMN_TITLE, GinfyDbAdapter.CATEGORY_COLUMN_CONTENT, GinfyDbAdapter.CATEGORY_COLUMN_COUNT}
        ImageButton button = (ImageButton) view.findViewById(R.id.btnaudioprayer);
        button.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                //ADD STUFF HERE you know which row is clicked. and which button
                typed = content;
                speakOut();
            }
        });
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.activity_row, parent, false);

        bindView(v,context,cursor);
        return v;
    }

}