@RequestMapping(value = "/accounts", method = RequestMethod.POST)
 public String handle(Account account, BindingResult result, RedirectAttributes redirectAttrs) {
   // Save account ...
   redirectAttrs.addFlashAttribute("message", "Account created!");
   return "redirect:/accounts/{id}";
 }