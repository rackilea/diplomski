finalPrice =0;
for (Item temp: cart)
{
    System.out.println(temp);
    double subTotal = ((temp.getPrice()) * (temp.getQuantity()));
    finalPrice += subTotal;
}