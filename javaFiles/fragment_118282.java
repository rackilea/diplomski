Iterator<Vehicle> iterator = vehicleLot.iterator();
while(iterator.hasNext())
{
  Vehicle vehicle = iterator.next();
  String flag = vehicle.getLicenseNumber().toString();
  if(flag.compareTo(licenseNum) == 0)
  {
    iterator.remove();
  }

}