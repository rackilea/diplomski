package com.viremp.beans;

import java.awt.AWTException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.viremp.component.HandleHobs;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -8650636789236091591L;

private static Logger LOGGER = LoggerFactory.getLogger(LoginBean.class);

private String username;

private String password;

private String error;

private boolean visible = false;

private HandleHobs handleHobs;

public String getUsername() {
    return username;
}

public void setUsername(String username) {
    this.username = username;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

public String getError() {
    return error;
}

public void setError(String error) {
    this.error = error;
}

public boolean isVisible() {
    return visible;
}

public void setVisible(boolean visible) {
    this.visible = visible;
}

/*
 * public LoginBean() { try { if (handleHobs != null &&
 * !handleHobs.isJobStoredScreenShotIsStarted()) { handleHobs = new
 * HandleHobs(); } } catch (Exception e) { LOGGER.error("error init job", e); }
 * 
 * }
 */

@PostConstruct
public void init() {
    try {

        handleHobs = new HandleHobs();

    } catch (Exception e) {
        LOGGER.error("error init job", e);
    }

}

public void login() throws ClassNotFoundException, SQLException, IOException, AWTException {
    // String un = "a";
    // String pw = "b";
    FacesContext context = FacesContext.getCurrentInstance();
    ExternalContext externalContext = context.getExternalContext();
    HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
    // Login login = new Login();
    // boolean isLoggedIn = login.LoginUser(username, password);
    try {
        request.login(username, password);

        handleHobs.startJobStoredScreenShot(username);
        externalContext
                .redirect(externalContext.getRequestContextPath() + "/faces/Success.xhtml?faces-redirect=true");
    } catch (Exception e) {
        FacesContext fc = FacesContext.getCurrentInstance();
        this.error = getErrorParam(fc);

        setVisible(true);
        System.out.println("not equal.. " + error);
        e.printStackTrace();
    }

    /*
     * 
     * if (isLoggedIn) { System.out.println("equal"); externalContext
     * .redirect(externalContext.getRequestContextPath() +
     * "/faces/Success.xhtml?faces-redirect=true"); } else {
     * 
     * FacesContext fc = FacesContext.getCurrentInstance(); this.error =
     * getErrorParam(fc);
     * 
     * setVisible(true); System.out.println("not equal.. " + error);
     * 
     * }
     */
}

public void logout() {

    System.out.println("in logotu");
    handleHobs.shutdownJobStoredScreenShot();
    this.handleHobs = null; // here i also made null
    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    externalContext.invalidateSession();
    try {
        externalContext
                .redirect(externalContext.getRequestContextPath() + "/faces/Login.xhtml?faces-redirect=true");
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}

public String getErrorParam(FacesContext fc) {

    Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
    return params.get("error1");

}
}