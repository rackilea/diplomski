System.out.print("give me the money:");//ask user of integer
while(!scanner.hasNextInt()){//test is provided value is valid integer
    String token = scanner.next();//consume incorrect value
    //inform that value is not correct and ask for new one
    System.our.println(token + " is not considered as valid number");
    System.our.print("please try again:");
}
//here we know that user provided valid integer
value = scanner.nextInt();