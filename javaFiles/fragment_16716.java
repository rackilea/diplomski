System.out.println("Before decryption:");
System.out.println(Arrays.deepToString(output));
int top, bottom;
bottom = this.size-1;
char[][] copy = new char[size][size];
for(top = 0; top<=bottom; top++,bottom--){
    char[] topMatrix = output[top];
    char[] bottomMatrix = output[bottom];
    System.out.println(top+" "+bottom);
    System.arraycopy(topMatrix, 0, copy[bottom], 0, size);
    System.arraycopy(bottomMatrix, 0, copy[top], 0, size);
}
System.out.println("After Decryption: ");
System.out.println(Arrays.deepToString(copy));