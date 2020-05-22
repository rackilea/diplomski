package com.abc.wls.security.providers.authentication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import weblogic.logging.NonCatalogLogger;
import weblogic.security.principal.WLSGroupImpl;
import weblogic.security.principal.WLSUserImpl;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WLServerLoginModule implements LoginModule {
    private static NonCatalogLogger logger = new NonCatalogLogger("WLServerLoginModule");
    // initial state
    private Subject subject;
    private CallbackHandler callbackHandler;
    private Map<String, ?> sharedState;
    private Map<String, ?> options;
    // the authentication status
    private boolean succeeded = false;
    private boolean commitSucceeded = false;

    // username and password
    private String username;
    private String password;
    Map<String, String> userData = new HashMap<String, String>();
    private final JsonParser jsonParser = new JsonParser();

    private WLSAuthPrincipal userPrincipal;

    public WLServerLoginModule() throws LoginException {
        super();
    }

    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
        logger.info("WLServerLoginModule.initialize");
        this.subject = subject;
        this.callbackHandler = callbackHandler;
        this.setSharedState(sharedState);
        this.setOptions(options);
        String appName = options.get("app-unique-name").toString();
        logger.info("AppName in WLServerLoginModule: " + appName);
    }

    public boolean login() throws LoginException {
        logger.info("WLServerLoginModule.login");
        if (callbackHandler == null)
            throw new LoginException("Error: no CallbackHandler available " + "to garner authentication information from the user");

        Callback[] callbacks = new Callback[2];
        callbacks[0] = new NameCallback("user name: ");
        callbacks[1] = new PasswordCallback("password: ", false);
        try {
            callbackHandler.handle(callbacks);
            username = ((NameCallback) callbacks[0]).getName();
            char[] tmpPassword = ((PasswordCallback) callbacks[1]).getPassword();
            if (tmpPassword == null) {
                // treat a NULL password as an empty password
                tmpPassword = new char[0];
            }
            password = new String(tmpPassword);
            if (isEmpty(username) || isEmpty(password)) {
                throw new LoginException("User name or password is empty");
            }
        } catch (java.io.IOException ioe) {
            throw new LoginException(ioe.toString());
        } catch (UnsupportedCallbackException uce) {
            throw new LoginException("Error: " + uce.getCallback().toString() + " not available to garner authentication information " + "from the user");
        }

        try {
            if (isValidUser(username, password)) {
                succeeded = true;
            } else {
                succeeded = false;
            }
        } catch (Exception e) {
            logger.error("Post validation exception e: ", e);
            succeeded = false;
        }
        return succeeded;
    }

    private boolean isValidUser(String username, String password) {
        // Your custom validation logic
        return true;
    }


    public boolean commit() throws LoginException {
        logger.info("WLServerLoginModule.commit");
        if (succeeded == false) {
            return false;
        } else {
            // add a Principal (authenticated identity) to the Subject
            // assume the user we authenticated is the SamplePrincipal
            userPrincipal = new WLSAuthPrincipal(username, password, userData);
            if (!subject.getPrincipals().contains(userPrincipal)) {
                // subject.getPrincipals().add(new WLSUserImpl(username));
                subject.getPrincipals().add(userPrincipal);
                logger.info("Custom User principal Added");
            }
            subject.getPrincipals().add(new WLSUserImpl(username));
            subject.getPrincipals().add(new WLSGroupImpl("ABC_USERS"));
            logger.info("Login Module successfully added user principal");
            if (subject != null && subject.getPrincipals() != null) {
                logger.info("All user principals added: " + subject.getPrincipals());
                logger.info("All user principals count: " + subject.getPrincipals().size());
            }
            // in any case, clean out state
            username = null;
            password = null;
            commitSucceeded = true;
            return true;
        }
    }

    public boolean abort() throws LoginException {
        logger.info("WLServerLoginModule.abort");
        if (succeeded == false) {
            return false;
        } else if (succeeded == true && commitSucceeded == false) {
            // login succeeded but overall authentication failed
            succeeded = false;
            username = null;
            password = null;
            userPrincipal = null;
        } else {
            // overall authentication succeeded and commit succeeded, but
            // someone else's commit failed
            logout();
        }
        return true;
    }

    public boolean logout() throws LoginException {
        logger.info("WLServerLoginModule.logout");
        subject.getPrincipals().remove(userPrincipal);
        succeeded = false;
        succeeded = commitSucceeded;
        username = null;
        password = null;
        userPrincipal = null;
        logger.info("Login Module successfully removed user principal after successful logout");
        return true;
    }

    public Map<String, ?> getSharedState() {
        return sharedState;
    }

    public void setSharedState(Map<String, ?> sharedState) {
        this.sharedState = sharedState;
    }

    public Map<String, ?> getOptions() {
        return options;
    }

    public void setOptions(Map<String, ?> options) {
        this.options = options;
    }
}