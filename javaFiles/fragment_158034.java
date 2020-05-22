rowItems = new ArrayList<RowItem>();

    for(int i =0; i<names.length; i++)
    {
        RowItem item = new RowItem(pics.get(i), names.get(i), descriptions.get(i));
        rowItems.add(item);
    }