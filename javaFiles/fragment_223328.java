@RequestMapping(params = "action=nuovoprodotto")    
public ModelAndView nuovoProdotto(
        @RequestParam(value = "page", required = false, defaultValue = "-1") int page,
        @RequestParam(value = "action") String action,
        @ModelAttribute Prodotto prod, HttpSession session)
        throws Exception {
        // some stuff here
}

@RequestMapping(params = "action=salvaprodotto")    
public ModelAndView salvaProdotto(
        @RequestParam(value = "page", required = false, defaultValue = "-1") int page,
        @RequestParam(value = "action") String action,
        @ModelAttribute Prodotto prod, HttpSession session)
        throws Exception {

        return nuovoProdotto(page, action, prod, session);
}