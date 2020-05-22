case 1:
    if(admin)
    {  //admin, change price
        c.println("Please enter the new price for the Low Pile Carpet: ");
        pileCost = c.readInt();
    }
    else
    { //non-admin, set price
        price = 18.75;
    }
break; //important! don't forget the break-keyword