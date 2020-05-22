package com.example.logintracker;

import java.time.Instant;
import java.util.UUID;

/**
 * The business logic for handling login attempts. Called by separate user interface code.
 *
 * This source code available via the Free Public License 1.0.0. http://opensource.org/licenses/FPL-1.0.0
 *
 * @author Basil Bourque
 *
 */
public class Authenticator {

    // User-interface makes this call to execute a user’s login attempt.
    public LoginAttempt authenticate ( String userName , String password ) {
        Boolean successful = Boolean.FALSE;

        // TODO: Add business logic to perform authentication. Hard-coded here to always succeed for this demonstration code.
        successful = Boolean.TRUE;
        LoginAttempt loginAttempt = new LoginAttempt ( userName , Instant.now () , successful , UUID.randomUUID () );

        // Remember this attempt.
        Persister persister = new Persister ();
        persister.saveLoginAttempt ( loginAttempt );

        return loginAttempt;
    }

    public LoginAttempt getMostRecentAttempt () {
        Persister persister = new Persister ();
        LoginAttempt loginAttempt = persister.fetchMostRecentLoginAttempt ();
        return loginAttempt;
    }

}