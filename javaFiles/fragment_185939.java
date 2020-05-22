public void onBind(int position) {
            super.onBind(position);
cardView.setVisibility(View.GONE);
for (int i = 0;i<mListResponseList;i++){
if (//Item from List 2 at Position 'Position' equals item on Position i of originallist){
cardView.setVisibility(View.VISIBLE);
break;
}