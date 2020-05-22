@PostMapping(value = "details")
    public ModelAndView details(@RequestBody UserBean userBean, HttpServletRequest request,
            HttpServletResponse response) {

        ModelAndView view = new ModelAndView();
        String username = userBean.getUsername();

        if (retrieveService.getdetail(userBean) != null) {
            view.setViewName("welcomes");
        }

    return view;
}