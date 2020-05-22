@RequestMapping(value = "/add-category", method = RequestMethod.POST)
public String handleRedirect(@RequestParam("redirect") String redirect, @RequestParam("path-var") String pathVar) {
        if (redirect.equals("foo")) {               
            return "redirect:/foo";         
        } else {
            return "redirect:/bar/" + pathVar;  
        }
    }