@Override
public View getChildView(final int groupPosition, final int childPosition,
        boolean isLastChild, View convertView, ViewGroup parent) {
    Page page =(Page) getChild(groupPosition, childPosition);
    convertView = inflater.inflate(R.layout.child_list_layout, null);
    Button mButton=(Button)convertView.findViewById(R.id.button1);
     mButton.setOnClickListener(new OnClickListener() {    
        @Override
        public void onClick(View v) {    
                Your code goes here ....      
        }
    });

    return convertView;
}