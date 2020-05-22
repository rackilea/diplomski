if(convertView==null)
          {
                 convertView = mInflater.inflate(R.layout.calendar_week, null,false);
                 holder = new ViewHolder();
                 holder.txtWeekdays=(CustomTextView)convertView.findViewById(R.id.weekdays);
                 convertView.setTag(holder);
          }
          ...