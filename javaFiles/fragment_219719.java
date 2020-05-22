public IceCreamTruck(String id,int s){ //this also serves as the constructor for truckID
    truckID=id;
    pertrucksnumsold=s;
    totalnumsold+=s;
    numTrucks ++;
    this.setTotalSales();
    this.setPerTruckSales();


}