int[] a = 
int[] b = 
int nullValue = 
for(int i: b) a[i] = nullValue;
int j=0;
for(int i=0; i < a.length; i++) {
    if(a[i] != nullValue)
       a[j++] = a[i];
}
// to clear the rest of the array, if required.
for(;j<a.length;j++)
   a[j] = nullValue;