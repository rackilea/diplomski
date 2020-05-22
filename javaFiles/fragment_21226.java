public void setValueAt(Object value, int row, int column)
{
    switch(column)
    {
    case 1: 
        basketItems.get(row).setBrand((String)value);
    case 2:
        basketItems.get(row).setModel((String)value);
    case 3:
        basketItems.get(row).setPrice((double)value);
    case 4:
        basketItems.get(row).setQuantity(Integer.parseInt((String) value));
    case 5:
        basketItems.get(row).setTotalPrice(Double.parseDouble((String) value));
    }
}