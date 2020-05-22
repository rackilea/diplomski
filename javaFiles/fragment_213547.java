class CustomAdapter extends BaseAdapter {

//create an instance 
private OnListItemClickListener onListItemClickListener;

//define the object setter
void setOnListItemClickListener(OnListItemClickListener listener)
{
this.onListItemClickListener=listener;}

        @Override
        public int getCount() {
            return comments_dateList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public boolean isEnabled(int position) {
            return false;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.customlayout_lastcomment_homepage, null);
            TextView textViewUser = (TextView) convertView.findViewById(R.id.textViewUser);
            TextView textViewDate = (TextView) convertView.findViewById(R.id.textViewDate);
            TextView textViewMessage = (TextView) convertView.findViewById(R.id.textViewMessage);
            textViewUser.setText(comments_userList.get(position));
            textViewDate.setText(comments_dateList.get(position));
            textViewMessage.setText(comments_messageList.get(position));


//Then here trigger

convertView.setOnClickListener(new View.OnClickListener()
{
  @override
  void onClick(View v)
  {
  onListItemClickListener.onListItemClicked(v,position);

  //you may be asked to set position as final
  }
});
            return convertView;
        }

    }