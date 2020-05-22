System.out.println("Enter the marks : ");   
for (int i =0; i < mark.length; i ++) {     
    System.out.printf("Enter integer mark %s between 0 and 100: ", i + 1);
    // assign each input to an index of the array
    mark[i] = input.nextInt();
}