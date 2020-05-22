while(sc.hasNext()) {                       
    // check student id
    if (sc.hasNext("[0-9]{6}")) {                 
        AM=sc.next(); // read student number
        System.out.println("AM: " + AM);
        if (AM.equals("000000")) break;
    } 
    // check if line ends prematurely --> error
    else if(sc.hasNext()== false) {
        System.out.println("Data format error.");
        //return;
    } 
    // check for a float
    else if(sc.hasNextFloat()){                  
        sum += sc.nextFloat();  // read the float
        count++;                                
    } 
    // check for "end"
    else if(sc.hasNext("end")){
        String endStr = sc.next(); // read "end"
        System.out.println("Average is " + sum / count);
        count = 0;
        sum = 0.0;
    } 
    // all other not yet considered strings (e.g. a course)
    else {        
        String course = sc.next();  // read course
    }
}