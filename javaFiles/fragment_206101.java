public int getNumber(){
    Scanner in =new Scanner(System.in);
    int validatedNumber;
    do{


    try{
        String toValidate=in.next();
        validatedNumber= Integer.parseInt(toValidate);
        if (validatedNumber>0 && validatedNumber<6){
            return validatedNumber;
        }else{
            System.out.println("Between 1 and 5!!");
        }
    }catch(Exception e){
        System.out.println("You have to chose a number!");
    }
    }while(true);

}