System.out.println("int[][] outputArray = {");   //int[][]outpuArray = {
for (int i = 0; i < myArray1.length; i++) {
    System.out.print("{");                       //{
    int j; 
    for (j = 0 ; j < myArray1[i].length - 1; j++) {
        //1, 2,...9,    i.e not last one.
        System.out.print(myArray1[i][j]+", ");   //1, 2,...9, then terminate
        //Not used if to check for last one because it would increase time complexity
    }
    System.out.print(myArray1[i][j]+"}");        //10} 
    if(i!=myArray1.length -1){                   
        System.out.println(", ");                //, only if it is not last one
    }
}
System.out.println("\n}");