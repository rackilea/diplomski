// if the next is a long, print found and the long 

    if (scanner.hasNextLong()) {
        System.out.println("Found :" + scanner.nextLong());
    }else{
       System.out.println("Not Found :" + scanner.next());
    }