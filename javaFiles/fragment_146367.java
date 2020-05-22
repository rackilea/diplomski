dump(theArray);
Arrays.sort(theArray, new Comparator<Integer[]>() {
    public int compare(Integer[] int1, Integer[] int2) {
        Integer numOfKeys1 = int1[1];
        Integer numOfKeys2 = int2[1];
        return numOfKeys1.compareTo(numOfKeys2);
    }
});
System.out.println("================");
dump(theArray);


0 10 
0 10 
1 9 
2 9 
3 9 
4 15 
5 10 
6 4 
7 8 
8 11 
9 12 
================
6 4 
7 8 
1 9 
2 9 
3 9 
0 10 
0 10 
5 10 
8 11 
9 12 
4 15