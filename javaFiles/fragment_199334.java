@RequestMapping(value="/add", method=RequestMethod.POST)    
public String addEmployee(@ModelAttribute("employee") Employee 
   employee, Model model) {  
//instead of Method=RequestMethod.POST your code were
//Method=RequestMethod,POST
 .. 
 }