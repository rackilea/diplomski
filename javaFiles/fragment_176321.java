private void setFilter(CharSequence cs) {
    String filterProducts[] = new String[]{};
    if (!TextUtils.isEmpty(cs)) {
        int j = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i].contains(cs)) {
                filterProducts[j] = cs.toString();
                j++;
            }
        }
        listAdapter = new ArrayAdapter < String > (this, R.layout.list_item, R.id.subject_name, filterProducts);
        list_view.setAdapter(listAdapter);

    }else{
        listAdapter = new ArrayAdapter < String > (this, R.layout.list_item, R.id.subject_name, products);
        list_view.setAdapter(listAdapter);
    }
}