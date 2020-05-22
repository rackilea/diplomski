int count = 0;
int currentObj = 0; // the object whose value is going to be printed
int numObjs = 6; // the number of objects to print
int size1 = 6; // number of rows
int size2 = 6; // number of positions in a row

// make sure you loop through every possible position
// the way you have it now stops after "2" is printed, leaving out the last "0"
while (count < size1 * size2) {
    count++; // increment the position every loop

    // if there are still objects to print out,
    // and if count is at the position of the current object
    //  pos of the objects is actually the number of positions before that value
    //  so pos is technically (position to print number - 1)
    if (currentObj < numObjs && (count - 1) == aList.get(currentObj).pos) {
        System.out.print(aList.get(currentObj).val + " ");
        currentObj++; // remember to increment to the next object

    // not at the position of an object's value, so print 0
    } else {
        System.out.print("0 ");
    }

    // go to the next line if size2 positions have been printed
    if (count % size2 == 0) {
        System.out.println("");
    }
}