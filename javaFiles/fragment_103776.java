public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
 Object handler) throws Exception{

    if(someCondition){
      return true; //continue processing
    }else{
      response.getOutputStream().write("{\"message\" : \"some text\"}");
      response.setContentType("text/json");
      response.setStatus(...); //some http error code?
      response.getoutputStream().flush();
      return false; //i have written some JSON to the response. Processing stops here
    }
}