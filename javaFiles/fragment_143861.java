@PostMapping("/bid/{id}")
   public ModelAndView bid(@PathVariable String id, 
    @ModelAttribute("bidDto") 
    @Valid BidDto bidDto, BindingResult bindingResult, Principal principal) {
         /* more code here */
         modelAndView.addObject("buyoutDto", new BuyoutDto());
    }