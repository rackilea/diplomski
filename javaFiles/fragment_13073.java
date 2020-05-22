String add3 = rs.getString("Stock");
if (Integer.parseInt(add3) == 0){
    txt_stock.setText("Out of Stock");
} else {
    txt_stock.setText(add3);
}