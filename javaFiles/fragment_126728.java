@Override
public void onClick(View view) {
    if (selectedItems.get(getAdapterPosition())) {
        selectedItems.delete(getAdapterPosition()); 
    } else {
       selectedItems.put(getAdapterPosition(), true); 
    }

   notifyItemChanged(int position) 
}