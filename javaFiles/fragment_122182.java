import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class HelperBean {

     public boolean isPostback() {
            FacesContext context = FacesContext.getCurrentInstance();
            return context.getRenderKit().getResponseStateManager().isPostback(context);
        }

}