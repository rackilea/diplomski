Vehicle lVehicleDB = lLocalDb.get(lVehicle.getId());
    if (null == lVehicleDB){
      lInsertList.add(lVehicleDB);
    }else{
      if (!lVehicleDB.isTechnicalEqual(lVehicle))
        lUpdateList.add(lVehicle);
    }