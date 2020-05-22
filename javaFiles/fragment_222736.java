//Inside onBindViewHolder method:
if(position > 0){
        // [----------------PREVIOUS ITEM-----------------]       [------------------CURRENT ITEM------------------]
    if(!list.get(position-1).getProfession().substring(0,1).equals(list.get(position).getProfession().substring(0,1))){
        //Example: holder.getDivisor().setVisibility(View.VISIBLE);
    }
}