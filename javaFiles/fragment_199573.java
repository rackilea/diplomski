public ActionForward addNewFunction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession(false);
        if(SecurityEJBServices.checkSession(session, request, response))
            return null;
        FunctionsServices fs = new FunctionsServices();
        FunctionForm functionForm = new FunctionForm(request);
        try{
            Function function = new Function();
            //set Function stuff here

            boolean added = fs.addFunction(function);

            PrintWriter out = response.getWriter();
            if(added){
                out.write("success");
            }else{
                out.write("error");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }