public View getView(int i, View view, ViewGroup viewGroup) {
    ...     
    Data ndata = catdata.get(i);

    holder.subcategories.setText(ndata.getSubcatergory());
    holder.categories.setText(ndata.getCatergory());

    if(ndata.getCatergory() == null) {
        holder.categories.setVisibility(View.GONE);
        holder.subcategories.setVisibility(View.VISIBLE);       
    }
    else {
        holder.categories.setVisibility(View.VISIBLE);
        holder.subcategories.setVisibility(View.GONE);      
    }

    return view;
}