@RequestMapping(value = "/doSomething")
        public @ResponseBody String doSomething(HttpServletRequest request, HttpServletResponse response, @RequestParam("d") String data) 
     {

            try {
                   ... do something here ...
                   response.setHeader("Access-Control-Allow-Origin", "*");
                   return "done";
            }
            catch (Exception e) {
                logger.debug("Exception occured when doing something", e);
                return "failure";
            }
        }