public String handleRequest(Model model){
   //arbitrary handling code
   model.addAttribute("bean", bean);
   model.addAttribute("userdetails", userdetails);
   //etc
   return "welcomePage";
 }