public class MyAdapter extends BaseAdapter {

        Context con;
        ArrayList<your type> mlist;
        RoomModel sched;

        public MyAdapter(Context con,ArrayList<your type> mlist )
        {
            this.con=con;
            this.mlist=mlist;

        }


        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return mlist.length;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return mlist[position];
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub

      sched=mlist.get(position);
        LayoutInflater inflater=(LayoutInflater)con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.your_layout,parent,false);


        TextView tv1=(TextView)convertView.findViewById(R.id.your_textview);
        tv1.setText(sched.getId());

       TextView tv2=(TextView)convertView.findViewById(R.id.your_textview);
        tv2.setText(sched.getName());

       TextView tv3=(TextView)convertView.findViewById(R.id.your_textview);
        tv3.setText(sched.getroomId());

            return convertView;
        }

  }