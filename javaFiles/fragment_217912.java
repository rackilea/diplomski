// declare
int[] a;
ArrayList<Integer> al;

// Instantiate
a=new int[6];
al=new ArrayList<>(6); // OR al=new ArrayList<>(); and let it expand itself

// add values
a[0]=5;a[1]=6;
al.add(0,5);al.add(1,6); // Note, if the index is greater 
                         // than the list size, the array 
                         // storage inside the list expands automatically

// Retrieve values
x=a[1];
x=al.get(1);

// Overwrite values
a[0]=9;
al.add(0,9);

// find array size:
len=a.length;
len=al.size();

// Iterate over:
for(int i:a) ...
for(int i:al) ... // Yes, identical