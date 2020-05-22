listview.setOnItemClickListener(new OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView parentView, View childView, int position, long id)    
    {
         CheckBox cb = (CheckBox) childView.findViewById(R.id.file_checkbox);
         cb.setChecked(true);
    }
}