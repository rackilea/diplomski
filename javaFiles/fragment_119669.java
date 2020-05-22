public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
        View convertView, ViewGroup parent) {
    TextView textView = getGenericView();
    textView.setText(getChild(groupPosition, childPosition).toString());
    textView.setOnClickListener(new View.OnClickListener(){
      public void onClick(View view){
        Uri uriToOpen = getUriForView(groupPosition, childPosition);
        Intent i = new Intent(Intent.ACTION_VIEW, uriToOpen);
        startActivity(i);
      });

    return textView;
}