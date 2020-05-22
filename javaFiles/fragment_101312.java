int rem = (num + 1) % 5;

for ( i = num; i >= num2 ; i--) {
      System.out.print(i+" ");
      if(i % 5 == rem){
         System.out.print( "\n" ); // this inserts the line break
      }
}