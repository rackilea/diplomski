import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class MyBackingBean {

    public boolean canEditAttachment(String componentId) {
        if ("cmdtop".equalsIgnoreCase(componentId))
            return true;
        else if ("cmddown".equalsIgnoreCase(componentId))
            return false;

        return true;
    }

}