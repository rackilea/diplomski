@SuppressWarnings("deprecation") 
final public class Temp extends SimpleFormController 
{         
    public Temp() 
    { 
        setCommandClass(ValidationForm.class); 
        setCommandName("validationForm"); 
    } 

    @Override 
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception 
    { 
        ValidationBean validationBean=(ValidationBean) command; 
        ModelAndView mv=new ModelAndView("Temp", "validationForm", validationBean); 
        if(errors.hasErrors()) 
        { 
            System.out.println("error"); 
            errors.reject("error.server.error");
            return showForm(request, response, errors);
        } 
        else 
        { 
            System.out.println("name = "+validationBean.getUserName()); 
        } 
        return mv; 
    }         

    @Override 
    protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors) throws Exception 
    { 
        ModelAndView mv=new ModelAndView("Temp", "validationForm", errors.getTarget()); 
        return mv; 
    } 
}