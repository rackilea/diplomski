try{        
    if((obj = in.readObject()) != null){

    if(obj instanceof String)
        output = (String) obj;

    if(output.equalsIgnoreCase("Bye"))
    s.stop();
    }
}
catch(ClassNotFoundException e){

    e.printStackTrace();
}
catch(IOException e){

    e.printStackTrace();
}