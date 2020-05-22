int n = 3; //change the value of n to increase the size of diamond
int upperCount = 1;
for(int i=n; i>=1; i--){

    for(int j=i; j>=1; j--){
       System.out.print(" ");
    }
    System.out.print(upperCount);

    for(int j=0; j<=upperCount-2; j++){
       System.out.print(" ");
    }

    for(int j=0; j<=upperCount-2; j++){
       System.out.print(" ");
    }

    if(upperCount!=1){
       System.out.print(upperCount);
    }

    upperCount++;
    System.out.print("\n");
}

int lowerCount = n-1;
for(int i=1; i<=n-1; i++){

    for(int j=0; j<=i; j++){
        System.out.print(" ");
    }
    System.out.print(lowerCount);

    for(int j=0; j<=lowerCount-2; j++){
       System.out.print(" ");
    }

    for(int j=0; j<=lowerCount-2; j++){
       System.out.print(" ");
    }

    if(lowerCount!=1){
       System.out.print(lowerCount);
    }

    lowerCount--;
    System.out.print("\n");
}