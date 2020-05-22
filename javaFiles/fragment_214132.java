@Override
public double getTotal()
{
    if(preferred){
        return myPrice - myDiscountAmount;
    }
    else return myPrice;
}