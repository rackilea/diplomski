int len = array.length;
char[] tempArray = new char[len];
int i=0, j=0, k=len-1;

while (i<len) {
   tempArray[i++] = array[j++];
   if (i<len) {
     tempArray[i++] = array[k--];
   }
}