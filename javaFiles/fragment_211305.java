else if(abc.equals("c")) {
    System.out.println("OK! Parked!!! What do you want to do?\n 1)Check your car status\n 2) exit ")
    int response = scan.nextInt();
    if(response == 1){
       System.out.println("Number of KM run = "+runKM +"\nAmount of litre in tank = "+startingLitre);
    }else {
       continued = false;
    }
}