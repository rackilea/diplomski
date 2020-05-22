public void add ( BinItem b)
{
    boolean added = false;
    for (int x = myContents.size() - 1; x >= 0; x--)
    {
        BinItem temp = myContents.get(x);
        String sku = temp.getSKU();
        if (sku.equals(b.getSKU())){
            myContents.remove(x);
            int quantityToAdd = temp.getQuantity();
            int bQuantity = b.getQuantity();
            BinItem newItem = new BinItem(sku, quantityToAdd + bQuantity);
            myContents.add(0, newItem);
            added = true;
        }
    }
    if (!added){
        myContents.add(b);
    }
}