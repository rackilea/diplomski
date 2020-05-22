Set<Set<Long>> longSetSet = null;
Set<Set<Double>> doubleSetSet = null;

Set<Set<? extends Number>> someNumberSetSet;

// try assigning them
someNumberSetSet = longSetSet;   //
someNumberSetSet = doubleSetSet; // compiler errors - incompatible types