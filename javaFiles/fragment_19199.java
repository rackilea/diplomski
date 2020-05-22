do{
    if(scan.hasNextInt()){
        operationResult = scan.nextInt();
        break;
    }else if(scan.next().trim().equals("x")){
        break;
    }else{
        System.out.println("Enter an Integer!!");
    }
}while(true);