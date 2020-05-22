try{
    char c;
    while((c = (char)in.read()) != -1) {
        msg += c;
    }
    in.close();
} catch(Exception e){
    System.out.println("Error: " + e);
}