public static int count7(int n){
if (n==7){
    return 1;
} else if (n < 7) {
    return 0; // I assumed you wanted to return 0, you can change this to return 1...
}
if (n%10 == 7){
    return 1 + count7(n/10);
}
else{
    return count7(n/10);
}
}