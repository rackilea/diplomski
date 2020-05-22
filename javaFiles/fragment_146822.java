@Override
public View getView(int position, View convertView, ViewGroup parent) {
     LinearLayout view = (LinearLayout) convertView;
     if (view == null) {
          view = (LinearLayout) inflater.inflate(R.layout.record_view_start, parent, false);
     }
     TextView tv = (TextView) view.findViewById(R.id.engName);
     tv.setText(getItem(position));
     CheckBox cBox = (CheckBox) view.findViewById(R.id.checkBox1);
     cBox.setTag(Integer.valueOf(position)); // set the tag so we can identify the correct row in the listener
     cBox.setChecked(mChecked[position]); // set the status as we stored it        
     cBox.setOnCheckedChangeListener(mListener); // set the listener    
     return view;
}

OnCheckedChangeListener mListener = new OnCheckedChangeListener() {

     public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {   
         mChecked[(Integer)buttonView.getTag()] = isChecked; // get the tag so we know the row and store the status 
     }
};