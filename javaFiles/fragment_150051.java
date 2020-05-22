@RequestMapping(value="/hello", method = RequestMethod.POST)
        public String employeeLogin(ModelMap model, HttpServletRequest request,
@RequestParam(value = "storeName", required = false) String storeName) {

String sname = storeName;
}