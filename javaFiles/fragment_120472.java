for (int pos = 0; pos < arrayToBeSorted.length; pos++) {
    for (int secondMarker = pos; secondMarker > 0; secondMarker--) {
        int currentValue = arrayToBeSorted[secondMarker];
        int valueBeingCheckedAgainst = arrayToBeSorted[secondMarker - 1];
        if (currentValue > valueBeingCheckedAgainst) {
            break;
        }
        arrayToBeSorted[secondMarker] = arrayToBeSorted[secondMarker - 1];
        arrayToBeSorted[secondMarker - 1] = currentValue;
    }
}