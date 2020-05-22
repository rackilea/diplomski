public double getShippingCharges()
{
    double charges;
    if (weight <= 2.0)
    { charges = (1.10 * Math.ceil(miles / 500));
    }
    else if ((weight > 2.0) && (weight <= 6.0))
    {
        charges = (2.20 * Math.ceil(miles  / 500 ));
    }
    else if ((weight > 6.0) && (weight <=10.0))
    {
        charges = (3.70 * Math.ceil(miles / 500 )); 
    }
    else 
    {
        charges = (4.80 * Math.ceil(miles  / 500));
    }
    return charges;

    }