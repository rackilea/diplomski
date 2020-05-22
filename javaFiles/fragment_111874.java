int i2;
while(true){
    System.out.print("Enter a second larger integer");
    if(in.hasNextBigInteger()){
        i2 = in.nextInt();
        if(i2 > i1){
            break;
        }else{
            System.out.println("Invalid Integer");
            System.out.println("Enter a second LARGER integer");
            String Invalid = in.next(); // <----- this line
        }
        break; // <------------ and this line
    }else{
        System.out.println("Invalid Integer");
        System.out.println("Enter a second LARGER integer");
        String Invalid2 = in.next();
    }
}