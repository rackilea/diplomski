public void bindView(View view, Context context, Cursor cursor) {
        CheckBox checkbox = (CheckBox)view.findViewById(R.id.completed);
        TextView due_date = (TextView)view.findViewById(R.id.due_date);

        String title = cursor.getString(cursor.getColumnIndex(Tasks.TITLE));
        boolean completed = Util.intToBool(cursor.getInt(cursor.getColumnIndex(Tasks.COMPLETED)));

        SimpleDateFormat format = new SimpleDateFormat("EEEEEE, MMM dd yyyy hh:mm aa");
        long unixTime = cursor.getLong(cursor.getColumnIndex(Tasks.DUE_DATE));
        Calendar due = Util.timestampToDate(unixTime);

        due_date.setText(format.format(due.getTime()));
        checkbox.setText(title);
        checkbox.setChecked(completed);
        // edit here ..
        checkbox.setOnCheckedChangeListener(
         new CompoundButton.OnCheckedChangeListener() {
          public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
          // update your value in the db
        });