do{
File f = new File("events.txt");
//Intro
System.out.println("Accessing Central Michigan University Historical Records...");
System.out.println("Searching for events that occurred during 1892...");
String [] targetDate = {"1892"};
Arrays.asList(targetDate).contains("1892");
    //If date is found, print.
    if(false){
        System.out.println("Date found in CMU Historical Records.");
        System.out.print(f);
    }
    //If date isn't found, notify user.
    else
        System.out.println("Date not found in CMU Historical Records.");