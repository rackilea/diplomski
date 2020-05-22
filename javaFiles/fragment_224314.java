while(true){
    try{
        y1=scanner.nextInt();
        break;//success break out of loop
    }catch(InputMismatchException e){
        System.out.println("incorrect input! \n");
        System.out.println("Please enter the second date \n");
    }
}