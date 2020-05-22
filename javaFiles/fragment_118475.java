//output total inventory value
    double total = 0.0;
    for (int i = 0; i < 5; i++){ 
        total +=  myTelevisions[i].getCalculateInventory();            
    }
    System.out.printf("Total Value of Inventory is: \t$%.2f\n", total);