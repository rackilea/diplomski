/**
 * Log user out of this device - this clears the active Digits session, if one exists
 * Note: You will no longer get updates to the user's profile information
 * (email, phone number, etc) without an active Digits session.
 */
public static void logout(){
    getInstance().sessionManager.clearActiveSession();
}