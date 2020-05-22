public void setValueAt(Object value, int row, int column)
{
    switch(column)
    {
    case 0: 
        basketItems.get(row).setBrand((String)value);
        break;
    case 1:
        basketItems.get(row).setModel((String)value);
        break;
    case 2:
        basketItems.get(row).setPrice((double)value);
        break;
    case 3:
        basketItems.get(row).setQuantity(Integer.parseInt((String) value));
        break;
    case 4:
        basketItems.get(row).setTotalPrice(Double.parseDouble((String) value));
        break;
    }
}