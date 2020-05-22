OnClickListener groupClickListener = new OnClickListener(){
    public void onClick(View v){
        Group clickedGroup = (Group) v.getTag();
        //DO SOMETHING
    }
};

LinearLayout ll = (LinearLayout)findViewById(R.id.groupsButtonList);

for(int index = 0; index < groupsList.size(); index++){
        Group singleGroup = groupsList.get(index);
        Button myButton = new Button(this);
        myButton.setTag(singleGroup);
        myButton.setOnClickListener(groupClickListener);
        myButton.setText(singleGroup.name);
}