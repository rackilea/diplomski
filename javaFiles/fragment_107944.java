final int TOTAL_BYTES_TO_INCLUDE = 9;

byte[] byteArray[] = new byte[TOTAL_BYTES_TO_INCLUDE];
int arrayIndex = 0;


for (int r = 0; r++; r < number_of_rows) {
  for (int c = 0; c++; c < 4) {
     byteArray[arrayIndex++] = getValue(r, c);
     if (arrayIndex >= TOTAL_BYTES_TO_INCLUDE) {
        ... do something with your byte array ...
        arrayIndex = 0;
     }
   }
}