if(isize <= 20)
{
     LineItem lineItem = items.get(i);
     lineItem.setQuantityCredit(credit);
     return; // This is the problem
}