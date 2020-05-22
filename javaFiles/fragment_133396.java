@Named
@RequestScoped

public class buttonController {  

@EJB mySec myClass;

public buttonController(){
}

public void adminMethod()
{
    if(myClass.ifManager())
        FacesContext.getCurrentInstance().addMessage(null, new  FacesMessage(FacesMessage.SEVERITY_INFO,"Hello Manager", "")); 
}
}