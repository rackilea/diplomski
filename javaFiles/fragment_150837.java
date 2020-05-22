public ManufacturedPart(int id) { // thrown not possible
     this(id, null, 0, 0, 0);
}

public ManufacturedPart(int id, double lCost, double mCost) 
         throws InvalidProductionArgumentException  { // it could happen here
    this(id, null, 0, lCost, mCost);
}