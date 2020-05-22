void removeOrderedItem(String item) {
 itemsOrderedList.remove(item);
 String strprice = item.split("   ")[1];
 strprice = strprice.replace("$", "");
 int price = (int) (Float.parseFloat(strprice) * 100);
 amount -= price;
 amountLabel.setText("$"+(float)amount/100);
}