for (Seat seat : newList) {
    if (seat.IsFree()) {
        if (startIndex < 0) {
            startIndex = index;
        }
        consecutiveLength ++;
    } else {
        consecutiveMap.put(startIndex + 1, consecutiveLength);
        if (consecutiveLength == n) {
            // Found, do something here
        }
        // Reset
        startIndex = -1;
        consecutiveLength = 0;
    }
    index++;
}
// added logic:
if (startIndex >= 0) {
    consecutiveMap.put(startIndex + 1, consecutiveLength);
}
return consecutiveMap;