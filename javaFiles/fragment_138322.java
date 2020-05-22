for (int i = 0; i < b.length - 1; i++) {// b.length - 1 I don't want to
    // print last element here since I don't want to add comma
    // after it
    System.out.print(b[i] + ", ");
}
// now it is time for last element of array
System.out.println(b[b.length - 1]);
//since b[]={1,2,3,4,5} b.length=5 so it will print b[4] -> 5