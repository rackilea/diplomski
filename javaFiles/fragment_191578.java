public void onClick(View v) {
        String name=listItemData.get(i).getName();
        Intent intent = Intent(mContext, SecondActivity.class);
        intent.putExtra("NAME", name);
        mContext.startActivity(intent);
    }