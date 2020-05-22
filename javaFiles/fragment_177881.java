@Override
 public void onClick(View v) {
     View parent = (View)v.getParent();
     ViewHolder vh = (ViewHolder)parent.getTag();
     TextView tv = vh.text1;
     speakOut(tv.getText().toString());
 }