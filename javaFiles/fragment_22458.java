int[] oldArray = {1,2,3,4,5};
Integer[] newArray = new Integer[oldArray.length];
int i = 0;
for (int value : oldArray) {
    newArray[i++] = Integer.valueOf(value);
}