if(!request.getHeader("X-Requested-With").equals("XMLHttpRequest")){
    out.println("AJAX Request only.");
    out.flush(); 
    out.close(); 
    return; 
}