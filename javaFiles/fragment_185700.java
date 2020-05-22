if(convertView == null) {

        if(object.get(position).equals("0")) {
            convertView = vi.inflate(R.layout.p_activity_detected, null);
            holder.textActivity = (TextView) convertView.findViewById(R.id.detected_text);
        }

        if(object.get(position).equals("1")) {
            convertView = vi.inflate(R.layout.p_activity_people, null);
            holder.textPeople = (TextView) convertView.findViewById(R.id.people_text);
        }

        holder = new ViewHolder();
        convertView.setTag(holder);