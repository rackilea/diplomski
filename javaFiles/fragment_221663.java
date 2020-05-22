void getItemLoc(String item, int price) {
    removeOrderedItem (item, price);
}

void removeOrderedItem(String item, int price) {
   itemsOrderedList.remove(item);
   amount -= price;
   amountLabel.setText("$"+(float)amount/100);
}