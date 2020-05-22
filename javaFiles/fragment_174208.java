Integer[] a2 = convertPrimitiveArrayToBoxableTypeArray(a1);
Arrays.sort(a2, new IntegerComparator()); // OR
// Arrays.sort(a2, Collections.reverseOrder());

//Unbox the array to primitive type
a1 = convertBoxableTypeArrayToPrimitiveTypeArray(a2);