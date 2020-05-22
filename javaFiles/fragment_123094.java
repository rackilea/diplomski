Object value = tbGudangSales.getValueAt(i, 5);

if (value != null)
{
    if(value.toString().trim().isEmpty()) // instead checking the length "manually", you can use the isEmpty() method
    {
        status = "tidak ada penjualan";
    } 
    else
    {
        status = value.toString();
    }
}