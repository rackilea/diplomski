if(scn.hasNextInt()) { //if true, you know that this file is ints
       while(scn.hasNextInt()) {
            int i = scn.nextInt(); //handle all as ints
       }
} else { //otherwise the file is strings
       while(scn.hasNext()) {
             String s = scn.next();
            //handle all as strings 
       }
}