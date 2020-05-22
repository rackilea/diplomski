if(kb.hasNextDouble()){
    payment = kb.nextDouble();
} else{
    System.out.println("Please enter valid currency");
    kb.next();
    continue;
}