public class IE8FilterResponseWrapper extends HttpServletResponseWrapper {


    public IE8FilterResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    public void forceContentType(String type) {
        super.setContentType(type); 
    }

    public void setContentType(String type) { 

    } 

    public void setHeader(String name, String value) {

        if (!name.equals("Content-Type")) {
            super.setHeader(name, value);
        }
    }

    public void addHeader(String name, String value) {
        if (!name.equals("Content-Type")) {
            super.addHeader(name, value);
        }

    }

     public String getContentType() { 
         return super.getContentType(); 
     } 
}