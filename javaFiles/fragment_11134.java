@Override
     public void onBindViewHolder(RecyclerViewHolder viewHolder, int i) {
     // get the single element from the main array
        Contact cn = contact.get(i);
        viewHolder.mDate.setText(cn.getmDate());
        viewHolder.mDay.setText(cn.getmDay());
        viewHolder.mMonth.setText(cn.getmMonth());
        viewHolder.mTime.setText(cn.getmTime());
        viewHolder.mTitle.setText(cn.getmTitle());
        viewHolder.mContent.setText(cn.getmContent());
        viewHolder.mTitle.setText(cn.getmTitle());
        viewHolder.mContent.setText(cn.getmContent());
        viewHolder.mMood.setImageResource(cn.getmMood());
        viewHolder.mWeather.setImageResource(cn.getmWeather());

      }