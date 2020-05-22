class CustomAdapter extends SimpleCursorAdapter {

        private LayoutInflater mInflater;


        @SuppressWarnings("deprecation")
        public CustomAdapter(Context context, int layout, Cursor c, String[] from, int[] to)
                 {
            super(context, layout, c, from, to);
            mInflater= LayoutInflater.from(context);
            Toast.makeText(YourPrayerActivity.this, "text", 1000).show();
            // TODO Auto-generated constructor stub
        }


         @Override
            public void bindView(View view, Context context, final Cursor cursor){
                int row_id = cursor.getColumnIndex("_id");  //Your row id (might need to replace)
                TextView tv = (TextView) view.findViewById(R.id.text1);
                final TextView tv1 = (TextView) view.findViewById(R.id.text2);
                int col1 = cursor.getColumnIndex("title");
                String title = cursor.getString(col1 );
                int col2 = cursor.getColumnIndex("content");
                final String content = cursor.getString(col2 );
                tv.setText( title);
                tv1.setText( content);
                Button button = (Button) view.findViewById(R.id.buttonsms);
                button.setOnClickListener(new OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Log.i("....................",""+cursor.getCount());
                        Toast.makeText(YourPrayerActivity.this, "text",400000).show();
                    }
                });
            }

            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent){
                LayoutInflater inflater = LayoutInflater.from(context);
                View v = inflater.inflate(R.layout.activity_row2, parent, false);

                bindView(v,context,cursor);
                return v;
            }
        }