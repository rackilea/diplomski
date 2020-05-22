public class MyAction implements ServletRequestAware {
    private javax.servlet.http.HttpServletRequest request;

    public void setServletRequest(javax.servlet.http.HttpServletRequest request){ 
        this.request = request;
    }

    public HttpSession getSession(){
        return request.getSession();
    }
}