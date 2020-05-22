try{
//get number

if(number<minRange || number>maxRange){
 throw new IllegalArgumentException();
}

//Rest of stuff


}catch(InputMismatchException e){
 System.out.println("Invalid input!");
 System.exit(-1);
}