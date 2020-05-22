ArrayAdapter<MyModel> answerAdapter = new ArrayAdapter<MyModel>(this,
        android.R.layout.simple_list_item_activated_1) {
    @Override
    public View getView(int position, View convertView,
            ViewGroup parent) {
        View v =super.getView(position, convertView, parent);;
        MyModel  model = getItem(position);
        if(model.isSelected){
           v.setBackgroundColor(Color.RED);} 
         else{
           v.setBackgroundColor(Color.WHITE);}
        return v;
    }

};