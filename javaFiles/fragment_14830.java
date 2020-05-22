@RequestMapping("/myPath.htm")
    public ModelAndView add(HttpServletRequest request,
         HttpServletResponse response) throws Exception{
            //Do service call passing the response
    return new ModelAndView("CustomerAddView");
    }

//Service code
Cookie myCookie =
  new Cookie("name", "val");
  response.addCookie(myCookie);