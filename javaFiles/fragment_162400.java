newMinutes = oldMinutes + addMinutes;           //add minutes
newHours = oldHours + addHours + newMinutes/60; //int truncation is ok, 61/60 = 1
newHours = newHours % 12; //convert to 12hr format
if(newHours == 0) { //12 % 12 is 0, set it back to 12 if that's the case
    newHours = 12;
}