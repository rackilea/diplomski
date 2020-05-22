// change this, if you want your long to start from 
// a different position in the array
int start = 0; 
for (int i = 0; i < longBytes.length; i ++) {
   bytes[start + i] = longBytes[i];
}