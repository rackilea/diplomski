finally{
    try{
        bfw.close();   <== exception occured here
        pw.close();    <== this is not execute
    }catch(Exception e){
        e.printStackTrace();
    }
}