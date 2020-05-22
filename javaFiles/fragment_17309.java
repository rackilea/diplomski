while (true) {
    try{
       newLine = in.nextLine();
    }
    catch(NoSuchElementException io){
        break;// exit the infinite loop
    }
    if(clientName==null) {
       clientName = newLine;
    }
    else {
       out.println(clientName+":  "+newLine);
       out.flush();
    }
}