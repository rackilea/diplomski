@RequestMapping(value = "/test", method = RequestMethod.POST)
@ResponseBody// <== this annotation will bind Arr class and convert to json response.
   public Arr addAnotherAppointment(
   HttpServletRequest request,
    HttpServletResponse response,
    @RequestBody Arr arr, 
    Model model,
    BindingResult errors) {
        return arr;
}