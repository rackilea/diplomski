package foo;

import java.io.IOException;
import java.io.Serializable;
import java.net.URLEncoder;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class NavBean implements Serializable {

    private String getView() {
        String viewId = "/showMessage.faces"; // or look this up somewhere
        return viewId;
    }

    /**
     * Regular link to page
     */
    public String getUrlLink() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        String viewId = getView();
        String navUrl = context.getExternalContext().encodeActionURL(
                extContext.getRequestContextPath() + viewId);
        return navUrl;
    }

    /**
     * Just some value
     */
    public String getValue() {
        return "" + System.currentTimeMillis();
    }

    /**
     * Invoked by action
     */
    public String invokeRedirect() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        String viewId = getView();
        try {
            String charEncoding = extContext.getRequestCharacterEncoding();
            String name = URLEncoder.encode("foo", charEncoding);
            String value = URLEncoder.encode(getValue(), charEncoding);
            viewId = extContext.getRequestContextPath() + viewId + '?' + name
                    + "=" + value;
            String urlLink = context.getExternalContext().encodeActionURL(
                    viewId);
            extContext.redirect(urlLink);
        } catch (IOException e) {
            extContext.log(getClass().getName() + ".invokeRedirect", e);
        }
        return null;
    }

}