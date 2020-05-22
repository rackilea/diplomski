if(amount >= 20)
{
    tmp = (int) amount/20;
    System.out.println (tmp + "$20 bills");
    amount = amount % 20;
}