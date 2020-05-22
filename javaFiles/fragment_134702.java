for(int i = 0; i <= array1.length - array2.length; i++) {
    for(int j = i; j < i + array2.length; j++) {
        System.out.print(array1[j]);
    }
    System.out.print(" ");
}