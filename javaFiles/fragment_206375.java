BigNum operator%(BigNum divisor)
{
    BigNum val = this;
    BigNum div = divisor;
    while(div < val)
    {
        div = div + divisor;
    }   

    return this - (div - divisor);
}