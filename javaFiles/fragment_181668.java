@RequestMapping(value = "/show", method = RequestMethod.GET)
public String show(ModelMap model, 
                    HttpServletRequest request, 
                    HttpServletResponse response) {

    if (isValidAsYouWant(request)) { // check validity 
         // setup reference data

        return "viewName";

    } else {
        response.setStatus(400);
        try {
            response.getWriter().write("Invalid Request");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;           
    }
}