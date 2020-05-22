for (int i=0; i<cart.size(); i++)
{
    Item temp = cart.get(i);
    System.out.println(temp);
    double subTotal = ((temp.getPrice()) * (temp.getQuantity()));
    finalPrice += subTotal;

}