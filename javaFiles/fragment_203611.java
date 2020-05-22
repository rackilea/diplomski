package com.example.logintracker;

import java.time.Instant;
import java.util.UUID;

/**
 *
 * Value object holding the data describing each login attempt: who was the user, when attempted, was the login successful.
 *
 * This source code available via the Free Public License 1.0.0. http://opensource.org/licenses/FPL-1.0.0
 *
 * @author Basil Bourque
 *
 */
public class LoginAttempt {

    private String userName;
    private Instant whenAttempted;
    private Boolean successful;
    private UUID uuid = null;

    public LoginAttempt ( String userNameArg , Instant whenAttemptedArg , Boolean successfulArg , UUID uuidArg ) {
//        System.out.println ( "Constructor of LoginAttempt: " + whenAttemptedArg + " user: " + userNameArg );
        this.userName = userNameArg;
        this.whenAttempted = whenAttemptedArg;
        this.successful = successfulArg;
        this.uuid = uuidArg;
    }

    // Getters. Read-only object.
    public String getUserName () {
        return this.userName;
    }

    public Instant getWhenAttempted () {
        return this.whenAttempted;
    }

    public Boolean getSuccessful () {
        return this.successful;
    }

    public UUID getUuid () {
        return this.uuid;
    }

    // Override Object.
    @Override
    public String toString () {
        return "LoginAttempt{ " + "userName=" + this.userName + " | whenAttempted=" + this.whenAttempted + " | successful=" + this.successful + " | uuid=" + this.uuid + " }";
    }

}