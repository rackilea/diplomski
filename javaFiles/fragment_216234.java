pay_adapter(ArrayList<pay_item> in) {
    data = in;
}

@Override
public int getItemCount() {
    return data.size() ;
}