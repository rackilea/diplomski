HashMap<String, petObject> petObjMap = new HashMap<String, petObject>();
    for(PetObject petObject : petObjectList){

        String id = petObject.getId();
        PetObject groupedObj = petObjMap.get(id);
        if( groupedObj == null ){
            petObjMap.put(id, petObject);
        }else{
            groupedObj.setDayOfTreatment(groupedObj.getDayOfTreatment + "," + petObject.getDayOfTreatment());
        }
    }