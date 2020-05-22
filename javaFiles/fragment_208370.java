private ArrayList<item> ItemList = new ArrayList<>();

void AddRow(item item, int index){
    ItemList.add(item);
    LinearLayout llItem = findViewById(R.id.llItem);
    View rowview = inflater.inflate(R.layout.cardrow, null);
    ImageButton btnDelete = rowview.findViewById(R.id.btnDelete);
    btnDelete.setOnClickListener(new View.OnClickListener(){
        @Override public void onClick(View v){
            list.remove(index);
            llItem.removeAllViews(); // <-- remove the views
            for(int i=0;i<item.getSize();i++){ // <-- add the rows again
                AddRow(item, i); // <-- rebuild accurate indices
            }
        }
    });
    llItem.addView(rowview, llItem.getChildCount());
}