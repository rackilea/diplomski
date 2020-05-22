for ( int row=0; row < data.length; row++) {
     int sum = 0;
     for ( int col=0; col < data[row].length; col++) {
          sum += data[row][col];
     }
     System.out.println("sum of row " + row + " is " + sum);
}