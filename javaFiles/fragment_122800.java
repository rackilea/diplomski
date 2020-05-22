// add a boolean
    boolean itemFound = false;
    for (int i = 0; i<items.length; i++){
        if(q == items[i].getCode()){
            items[i] = new Items(items[i].getCode(), items[i].getDescription(), items[i].getQuantity(),
                    items[i].getcostPrice(), items[i].getsellingPrice(),
                    u, items[i].getDiscount());
            itemFound = true;
        }
    }

    if (!itemFound){
        System.out.println("The Item is not found");
    }