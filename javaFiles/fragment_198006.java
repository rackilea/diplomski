//In the SwipeListAdapter class add
public void add(Product p) {
    productList.add(0, p);
    arraylist.add(0, p);
    notifyDataSetChyanged();
}