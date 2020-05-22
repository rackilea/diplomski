Date oldDtEffet = (Date) event.getOldState()[i];
Date newDtEffet = (Date) event.getState()[i];
if(oldDtEffet != null && newDtEffet != null &&
        DateUtils.isDateEqualsWithoutTime(oldDtEffet,newDtEffet)){
    event.getOldState()[i] = event.getState()[i];
}