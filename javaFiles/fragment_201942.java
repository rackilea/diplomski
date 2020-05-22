// initialize selectPosition in your base adapter
    int selectedPosition =   -1; 

    @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;

            if (convertView == null) {
                // brand new
                convertView = LayoutInflater.from(mContext).inflate(R.layout.person_list_item , null);
                holder = new ViewHolder();
                holder.nameText = (TextView) convertView.findViewById(R.id.nameTextView);
                holder.birthDateText = (TextView) convertView.findViewById(R.id.birthDateTextView);
                holder.checkBoxList = (CheckBox) convertView.findViewById(R.id.checkBox);

                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            Person personForList = mPersonArray[position];

            holder.nameText.setText(personForList.getName());
            holder.birthDateText.setText(personForList.getBirthDate());
          holder.checkBoxList.setChecked(position == selectedPosition);
                 holder.checkBoxList.setTag(position);
        holder.checkBoxList.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        selectedPosition = (Integer) view.getTag();

                        notifyDataSetInvalidated();
                        notifyDataSetChanged();
                    }
                });




            return convertView;
        }