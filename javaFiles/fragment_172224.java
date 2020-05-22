String[][] array2 = new String[array.length*2][array.length];

for (int mb = 0; mb < array.length; mb++) {
    String p1 = array[0][mb];  

     array2[mb][0] = p1;
     int count = 0;
     for (int i=1;i<=mb;i++) {
         count++;
         String p2 = array[i][mb-i];
         array2[mb][count] = p2;
     }
} 

int counter = -1;
for (int mb = array.length -1; mb > 0; mb--) { 
    counter++;
    String p1 = array[array.length -1][mb];  

    array2[mb+array.length -1][counter] = p1;
    for (int i=0;i<counter;i++) {
        String p2 = array[array.length -2 - i][array.length -counter + i];
        array2[mb+array.length -1][i] = p2;
    }
}