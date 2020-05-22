double totalPrice = 0.0;
for (int i = 0; i < bookArray.length; i++) { //can't use foreach because of use of parallel arrays bookArray & quantityArray
    Book b = bookArray[i];
    double price = b.getPrice() * quantityArray[i];
    totalPrice += price;
    String bookStr = String.format(" %s, %s %s", b.getTitle(), b.getIsbn(), 
        DecimalFormat.getCurrencyInstance().format(price));
    JOptionPane.showMessageDialog(null, bookStr);
}
String totalStr = String.format("Total Charge: %s", 
    DecimalFormat.getCurrencyInstance().format(totalPrice)));
JOptionPane.showMessageDialog(null, totalStr);