while (theFile.hasNext()) {  // change to `scnFile.hasNext()`
    String s1 = theFile.next();  // change to `scnFile.next()`
    Double d1 = theFile.nextDouble();  // change to `scnFile.nextDouble()`

    System.out.println(s1 + "   " + d1);
}