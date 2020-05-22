int[] C = createIntArray_descending();
int found, target, from, to;
int[] array;

array = C;
target = 5;
from = 0;
to = array.length-1;
printArray(array);
bubble_sort(array);
printArray(array);

found = searchAscending(target, array, from, to);
System.out.println(found);
found = searchAscending(5, C, 0, C.length-1);
System.out.println(found);