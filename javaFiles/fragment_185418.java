int [] a = { 4,5,100,6,6,4 };
int index = -1;
for (int i = 0; i < a.length; i++) {
    if (a[i] == 100) {
        index = i;
        break;
    }
}
int [] aBefore = new int[index];
int [] aAfter = new int[a.length-index-1];
System.arraycopy(a, 0, aBefore, 0, index);
System.arraycopy(a, index+1, aAfter, 0, a.length-index-1);