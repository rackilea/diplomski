// expiry date is BEFORE the date + "range" years ahead
    if (cc.getExpiryDate().compareTo(newDate) < 0)
    {
        // the expiry date is AFTER or ON the current date
        if(cc.getExpiryDate().compareTo(new Date()) >= 0)
        {
            out.print("*");
        }
    }
    out.print(cc.getNumber());
    out.println("\t" + sf.format(cc.getExpiryDate()));