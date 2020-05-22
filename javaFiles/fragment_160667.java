//For loop to check if any of the elements match the CDId. The variable exists will be
//set to true if it already exists in the array.
boolean exists = false;
if(CDId != null) {
    for(int i = 0; i < cdArray.length; i++) {
        if(cdArray[i] == null) continue;
        if(CDId.equalsIgnoreCase(cdArray[i].getCdId())) {
            exists = true;
            break;
        }
    }
}
if(exists) {
    //If the CDId already exists... (put your own code if you want, such as an error message)
} else {
    //If the id doesn't exist in the array yet, add the cd_obj to the array...
    boolean added = false;
    for(int i = 0; i < cdArray.length; i++) {
        if(cdArray[i] == null) {
            cdArray[i] = cd_obj;
            added = true;
            break;
        }
    }
    //if the cd_obj wasn't added to the array, notify the user.
    if(!added) {
        System.out.println("The array is full");
    }
}