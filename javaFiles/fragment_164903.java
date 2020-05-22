while(itr.hasNext())
{
    Object o = itr.next();
    if(o instanceof Market){
        Market mt = (Market) o;
        System.out.println(mt.billamount);
        System.out.println(mt.customer);
        System.out.println(mt.invoiceno);
    }else if(o instanceof RetailShop){
        RetailShop rts=(RetailShop) o;
        System.out.println(rts.custName);
    }

}