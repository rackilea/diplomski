package com.my.ws.validator;

import com.sun.xml.wss.impl.callback.PasswordValidationCallback.PasswordValidationException;
import com.sun.xml.wss.impl.callback.PasswordValidationCallback.PasswordValidator;
import com.sun.xml.wss.impl.callback.PasswordValidationCallback.PlainTextPasswordRequest;
import com.sun.xml.wss.impl.callback.PasswordValidationCallback.Request;

public class SecurityValidator implements PasswordValidator {

    private static final ThreadLocal<String> username = new ThreadLocal<String>();
    private static final ThreadLocal<String> password = new ThreadLocal<String>();

    @Override
    public boolean validate(final Request request) throws PasswordValidationException {

        if (request instanceof PlainTextPasswordRequest) {
            PlainTextPasswordRequest plainText = (PlainTextPasswordRequest) request;

            if (null == plainText.getUsername() || plainText.getUsername().trim().isEmpty())
                throw new PasswordValidationException("A username must be provided");
            else
                username.set(plainText.getUsername());

            if (null == plainText.getPassword() || plainText.getPassword().trim().isEmpty())
                throw new PasswordValidationException("A password must be provided");
            else
                password.set(plainText.getPassword());

            return true;
        }

        return false;
    }

    public static String getUsername() {
        String user = username.get();
        username.remove();
        return user;
    }

    public static String getPassword() {
        String pass = password.get();
        password.remove();
        return pass;
    }

}