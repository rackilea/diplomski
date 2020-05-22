@Controller
@RequestMapping("/Temp.htm")
public class Temp {

@RequestMapping(method=RequestMethod.GET)
public ModelAndView getForm() {
  ModelAndView mv=new ModelAndView("Temp", "validationForm", new ValidationForm());
  return mv;
}

@RequestMapping(method=RequestMethod.POST)
public ModelAndView postForm(@Valid ValidationForm validationForm, BindingResult errors) {
        tempService.add(validationForm);   //May not be necessary.        

        if(errors.hasErrors())  //Never evaluates to true even though the text box on the form is left blank.
        {                
            System.out.println("User Name : "+validationForm.getUserName());
            //Or do something.
        }    
        else
        {
            //Do some stuff such as database operations like insert, update or delete. 
        }         

        ModelAndView mv=new ModelAndView("Temp", "validationForm", validationForm);
        return mv;
}