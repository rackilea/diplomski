try {
    ...
} catch(ArrayIndexOutOfBoundsException e){
    System.out.println("Array index out of bound exception");
    return; // <<== Here
}