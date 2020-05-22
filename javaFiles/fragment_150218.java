1555 protected void complete()
 1556       {
 1557           if (!isTimeSet)
 1558               updateTime();
 1559           if (!areFieldsSet || !areAllFieldsSet) {
 1560               computeFields(); // fills in unset fields
 1561               areAllFieldsSet = areFieldsSet = true;
 1562           }
 1563       }