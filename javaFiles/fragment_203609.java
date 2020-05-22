package com.example.logintracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Contrived app to demonstrate saving login attempts to a database.
 *
 * This source code available via the Free Public License 1.0.0. http://opensource.org/licenses/FPL-1.0.0
 *
 * @author Basil Bourque
 */
public class App {

    public static void main ( String[] args ) {
        App app = new App ();

        // Report the most recent login attempt.
        Authenticator authenticator_Reporter = new Authenticator ();
        LoginAttempt loginAttempt_Recent = authenticator_Reporter.getMostRecentAttempt ();
        System.out.println ( "Recent loginAttempt: " + loginAttempt_Recent );

        // Attempt a login.
        Authenticator authenticator_Login = new Authenticator ();
        ArrayList<String> userNames = new ArrayList<> ( Arrays.asList ( "Wendy" , "Lisa" , "Jesse" , "Oliver" , "Jasmine" , "Jean-Luc" , "Jarrod" , "Evonne" , "Elise" ) ); // Pick a name at random.
        String userName = userNames.get ( new Random ().nextInt ( userNames.size () ) ); // From user-interface.
        String password = "pw"; // From user-interface.
        LoginAttempt loginAttempt_Now = authenticator_Login.authenticate ( userName , password );
        System.out.println ( "Fresh loginAttempt: " + loginAttempt_Now );
        if ( loginAttempt_Now.getSuccessful () ) {
            // Run the app for this user.
            // TODO: implement.
        } else {
            // Else block this user from running this app.
            // TODO: implement.
        }
    }
}