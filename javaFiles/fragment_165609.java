@RequestMapping("/postData")
 public @ResponseBody postData(Model model, 
             @RequestBody Comment comment,
             HttpServletRequest request) throws Throwable{

    String sendURL= request.getParameter("sendURL");

    System.out.println(this.getClass() + " : comment : " + comment.toString());

    /* Process data and formulate a response.... */

    AjaxResponse ajaxResponse = new AjaxResponse(processedResponseText, processedResponseCode);

    return ajaxResponse;
 }