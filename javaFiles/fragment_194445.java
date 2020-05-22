System.out.print("Best order for $" + totalMoney + " is: ");
    for(int i=0; i<items.length; i++)
    {
        if((bestPurchaseSet & (0x1 << i)) != 0)
        {
            System.out.print(items[i].name + ", ");
        }
    }

    System.out.println("The tip is " + (totalMoney - bestCost)/bestCost * 100 + "%");