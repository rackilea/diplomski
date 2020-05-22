public ModelAndView handleRequest(final HttpServletRequest request, HttpServletResponse response) throws Exception {

        sessionHelper.invalidate(request, new String[] { SubmitController.CONFIRMATION_INFO,
                                                         SubmitController.CONFIRMATION_INFO2,
                                                         SubmitController.CONFIRMATION_INFO3,
                                                         "changePrdStatus"  });                 
        HttpSession session = request.getSession();

        DetailedUser ecasUser = (DetailedUser)request.getUserPrincipal();

        User usr = userService.getUserFromLDAP(ecasUser);

        Integer numOfUser = usr.getNumberOfUserWithSameEmail();
      if(numOfUser>1){
          throw new SameEmailException("more than 1 user with the same email");
         }
..
}