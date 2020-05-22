public static void printContour(float []altitude, int[]x, int[]y){
   for (int i = 0; i < 100; i++) {
        for (int a = 0; a < 100; a++) {
            if (x[i] <  x[a]) {
                int temp_for_x = x[i];
                x[i] = x[a];
                x[a] = temp_for_x;
                int temp_for_y = y[i];
                y[i] = y[a];
                y[a] = temp_for_y;
                float temp_for_alt = altitude[i];
                altitude[i] = altitude[a];
                altitude[a] = temp_for_alt;
            }
            if(y[i] < y[a]){
                int temp_for_x = x[i];
                x[i] = x[a];
                x[a] = temp_for_x;
                int temp_for_y = y[i];
                y[i] = y[a];
                y[a] = temp_for_y;
                float temp_for_alt = altitude[i];
                altitude[i] = altitude[a];
                altitude[a] = temp_for_alt;
            }
        }
    }

    for (int incr=0;incr<100;incr++) {
         System.out.print(x[incr]+ "   " + y[incr] + "   " + altitude[incr]+ "   ");
         if(incr%10 == 9)
            System.out.println();

   }



}
}