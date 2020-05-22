private void selectOnly(int position){
    for(int a=0;a<list.size();a++){
        if(a == position){
            list.get(a).setChecked(true);
            continue;
        }
        list.get(a).setChecked(false);
    }//for loop
    notifyDataSetChanged(); // to update views (checkbox state)
}