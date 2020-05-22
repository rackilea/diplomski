public Lamborghini[] getCarsWithHorsepowerRange(double lowHP, double highHP){
    int horsePower = 0;

    for(int i = 0; i < inventory.size(); i++){
        if(inventory.get(i) != null){
            if((inventory.get(i).getHorsePower() >= lowHP) &&
               (inventory.get(i).getHorsePower() <= highHP)){
                horsePower++;
            }
        }
    }
}