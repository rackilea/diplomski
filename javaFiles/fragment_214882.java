int lowerCount = n-1;
for(int i=n-1; i>=2; i--){
    for(int j=1; j<=(n-i); j++){
       System.out.print(" ");
    }
    System.out.print(i);

    for(int j=1; j<=lowerCount; j++){
       System.out.print(" ");
    }
    System.out.print(i);
    lowerCount-=2;
}