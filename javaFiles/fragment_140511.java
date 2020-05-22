if (dataOne.moveToFirst()) {
    do {
        for(int iCopy=0;iCopy<imageTypeMandatory.length;iCopy++){
            if(imageTypeMandatory[iCopy].trim().equalsIgnoreCase(dataOne.getString(0).trim())){
                mandatoryCount++;
                imageTypeMandatoryCopy[iCopy]="";
            }   
        }
    } while(dataOne.moveToNext());
}