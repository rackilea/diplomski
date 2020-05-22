public abstract class AbstractController { 
    protected String portletBaseViewName = "";      

    public void setPortletBaseViewName(String portletBaseViewName) { 
        this.portletBaseViewName = portletBaseViewName; 
    } 
} 

@Controller  
@RequestMapping("VIEW")  
public class ReservationOfBooksViewController extends AbstractController{  
    public ReservationOfBooksViewController() {
        this.portletBaseViewName = "reservationOfBooks";
    }
}