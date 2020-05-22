public int setVehicleID(int VehicleID) throws TractorException
{
   if (VechicleID <= 0) {
     throw new TractorException("Invalid VIN: " + VehicleID);
   }
   else {
     this.VehicleID = VehicleID;
     return this.VehicleID;
   }

}