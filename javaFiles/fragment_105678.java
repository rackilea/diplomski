AddFarmCoordinatesResponse addFarmCoordinatesResponseRealm=realm1.where(AddFarmCoordinatesResponse.class)
    .equalTo("farmerId",addFarmCoordinatesResponse.getFarmerId())
    .findFirst();
    if(addFarmCoordinatesResponseRealm!=null && addFarmCoordinatesResponseRealm.getPath()!=null){
    addFarmCoordinatesResponseRealm.getPath().deleAllFromRealm;
    }

    then call realm1.insertOrUpdate( addFarmCoordinatesResponse);