//set background color in odd items
    LinearLayout groupLayout=(LinearLayout)convertView.findViewById(R.id.groupLinearLayout)
    if(groupPosition%2==0){
        groupLayout.setBackgroundResource(R.color.gray15p);
    } else {
        groupLayout.setBackgroundResource(R.color.gray30p); // <-- important part.
    }