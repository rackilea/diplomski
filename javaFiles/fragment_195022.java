for(int i = 1; i < N; i++) {
    for(int j = 1; j < i; j++); //<-- remove this semicolon
    {   // <-- use curly braces here for the loop statements
        int product = i * j;
        System.out.print(i +" * " +j +" = " +product+" "); //<--add an additional space at the end
    }
    System.out.println();       
}