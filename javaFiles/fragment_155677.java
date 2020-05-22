@RequestMapping(value = "/uploadImage", method = { RequestMethod.POST })
    public ModelAndView addUser(/* @RequestParam(value = "file") MultipartFile file, */ HttpServletRequest request,
            ModelMap model) {

        return new ModelAndView("redirect:/", model);
    }