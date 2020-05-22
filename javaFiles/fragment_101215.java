public void displayMethod()
 {
     long start= System.currentTimeMillis();
     System.out.println("The start time is" + start);
     for (ITERATIONS AND STUFF)
     {
        System.out.format(STUFF BEING PRINTED);
        System.out.println(System.currentTimeMillis());
    }   

    long end=System.currentTimeMillis();
    System.out.println("The end time is" + end);
    double difference = end-start;
    System.out.println("The difference " + difference);
 }