@RequestMapping("/pageA/{parameter}")
public String displayPageA(Model model, @PathVariable String parameter) {
   if(parameter == null)
   {
      model.addAttribute("your_form", new YourForm());
      return "pageA";
   }
   else {
      return "redirect:/pageB/"+parameter;  // this is if you want the parameter passed on
   }
}