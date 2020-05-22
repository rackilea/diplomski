public String ListStudents(ModelMap model) 
 { 
     List<Student> list= YourServiceClassObj.listStudents();
      model.addAttribute("result", list);
     return "View Name here"; 
 }