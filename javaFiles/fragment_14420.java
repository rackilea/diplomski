MappedByteBuffer bb;
…
// write your data

bb.force();// ensure completion of all writes
bb.put(specialPosition, specialMarkerValue);
bb.force();// ensure visibility of the marker