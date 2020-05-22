public View getView(int position, View convertView, ViewGroup parent) {
tf=Typeface.createFromAsset(context.getAssets(),"BFantezy.ttf"); 
View rowView = convertView;
if (rowView == null) {
  LayoutInflater inflater = context.getLayoutInflater();
  rowView = inflater.inflate(R.layout.list_item, null);
}
  int resourceToUse = R.string.day1;
switch(position){
  case 1: 
      resourceToUse = R.string.day1;
      break;
  case 2: 
      resourceToUse = R.string.day2;
      break;              
  case 3: 
      resourceToUse = R.string.day3;
      break;
  case 4: 
      resourceToUse = R.string.day4;
                         }

  TextView mTextView = (TextView) rowView.findViewById(R.id.label);
  mTextView.setTypeface(tf); 
  mTextView.setText(Html.fromHtml(context.getString(resourceToUse)));

  return rowView;  
}