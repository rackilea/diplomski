SimpleHashtable<Object> sh;
// ...
Object[] arr = new Object[sh.size()];
int pos = 0;
for (Object obj : sh) {
  arr[pos++] = obj;
}