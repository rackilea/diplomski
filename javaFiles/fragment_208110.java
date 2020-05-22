public class User {


// the ID is the user's IP address
private String id;

// connection status
public enum Connection
{
    CONNECTED,
    DISCONNECTED
}

private Connection status;

// the time of disconnection
private Calendar disconnectionDate;

// each user needs a WebSocket Session to be able to send and receive messages
private Session userSession;

/** 
 * @return the id of this user
 */
public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

/**
 * @return connection status
 */
public Connection getStatus() {
    return status;
}

public void setStatus(Connection status) {
    this.status = status;
}

public Calendar getdisconnectionDate() {
    return disconnectionDate;
}

public void setdisconnectionDate(Calendar disconnectionDate) {
    this.disconnectionDate = disconnectionDate;
}

/**
 * @return the userSession
 */
public Session getUserSession() {
    return userSession;
}

/**
 * @param userSession the userSession to set
 */
public void setUserSession(Session userSession) {
    this.userSession = userSession;
}

/**
 * @param newID the new ID of the user
 */
public User (String newID)
{
    this.id = newID;
    this.status = Connection.CONNECTED;
}

/**
 * Toggles the connection
 * @param toggle - if true, the user is connected
 */
public void toggleConnection(boolean toggle)
{
    if (toggle == false)
    {
        status = Connection.DISCONNECTED;
        disconnectionDate = Calendar.getInstance();
    }
    else
    {
        status = Connection.CONNECTED;
        disconnectionDate = Calendar.getInstance();
        disconnectionDate.add(Calendar.HOUR, 1);        // give an extra hour to prevent them being disconnected too soon

    }
}