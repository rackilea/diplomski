public void printNames(HttpServletRequest request){
    for(Part part : request.getParts()){
        System.out.println("PN: "+ part.getName());
        Collection<String> headers = part.getHeaders("content-disposition")
        if (headers == null)
            continue;
        for(String header : headers){
            System.out.println("CDH: " + header);                  
        } 
    }
}