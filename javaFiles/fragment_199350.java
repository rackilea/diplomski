class MyAdpter extends ArrayAdapter
        {

            int layout;
            ArrayList<Data> arr;
            Context con;

            public MyAdpter(Context context, int textViewResourceId, ArrayList<Data> objects) {
                super(context, textViewResourceId, objects);

                layout=textViewResourceId;
                arr= objects;
                con=context;
                // TODO Auto-generated constructor stub
            }
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // TODO Auto-generated method stub
                final ViewHolder  holder=new ViewHolder();
                if(convertView==null)
                {
                    LayoutInflater inflator=(LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView=inflator.inflate(layout, parent, false);
                    holder.tv=(TextView) convertView.findViewById(R.id.text);
                    holder.btn=(Button) convertView.findViewById(R.id.button);

                }



                holder.btn.setText("Data");
                holder.btn.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        // TODO Auto-generated method stub
                        Toast.makeText(con, ""+holder.btn.getText(), 800).show();

                    }
                });

                holder.tv.setText("DATA");


                return convertView;
            }

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return super.getCount();
            }

        }
        static class ViewHolder
        {
            TextView tv;
            Button btn;
        }