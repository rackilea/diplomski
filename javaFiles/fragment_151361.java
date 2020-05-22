@Override
public View getView(final NLevelItem item) {
// .......

    final CheckBox checkBox = (CheckBox)view.findViewById(R.id.check);
    checkBox.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //store checkbox state, note that NLevelItem item might need to be defined with 'final'
            item.setChecked(checkBox.isChecked());

            if(checkBox.isChecked()){
                tempList.add((String) ((SomeObject)childs.getWrappedObject()).getName()+"+"+name);
            }
            else {
                tempList.remove((String) ((SomeObject)childs.getWrappedObject()).getName()+"+"+name);
            }
        }//onClick()
    }//setOnClickListener()

    //update checkbox state from the corresponding NLevelItem
    checkBox.setChecked(item.isChecked());

    //.......
}//getView()