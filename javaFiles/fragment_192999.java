for (int i=0; i < dynArray1.length; i++) {
    dynArray3[i] = dynArray1[i];
}
for (int i=0; i < dynArray2.length; ++i) {
    dynArray3[i + dynArray1.length] = dynArray2[i];
}

// then print out the third array
for (int i=0; i < dynArray3.length; ++i) {
    System.out.println(dynArray3[i]);
}