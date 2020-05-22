int returnVal = 0;
try {
 returnVal = sdf1.parse(object2.getManufacturedDate()).compareTo(sdf1.parse(object1.getManufacturedDate()));                             
} catch (Exception e) {
  log.error("Error inside sortList method"+e);
}
return returnVal;