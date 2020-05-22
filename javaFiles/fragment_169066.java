public boolean AddToFile(BookingInformation bookinfos){
    try{       
    PrintWriter Bpw=new PrintWriter(new FileOutputStream("AllBookRecords.txt",true));
    Bpw.println(bookinfos.getBookName()); // Or whatever you see fit.
    return true;
    }
    catch(IOException ioe){
    return false;
    } 
}