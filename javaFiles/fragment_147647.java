package snippet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// You don't need to implement Comparator.
public class SessionAttributes implements Comparable<SessionAttributes> {

    // You typically define member variables at the top of the class definition.
    private final String userName;
    private final String sessionState;

    public SessionAttributes(String userName, String sessionState) {

        // Throw a NullPointerException from the constructor if either of the Strings is null. This way, you know that
        // if the object is constructed successfully, it is free of nulls.
        if (userName == null) {
            throw new NullPointerException("userName must not be null");
        }
        if (sessionState == null) {
            throw new NullPointerException("sessionState must not be null");
        }
        /*
         * String nasPort, String endpointProfile, String audiSessionId, String epsStatus, String securityGroup, String
         * nasIp, String postureStatus, String postureTimestamp) {
         */

        this.userName = userName;
        this.sessionState = sessionState;

        /*
         * this.nasPort = nasPort; this.endpoinProfile = endpointProfile; this.auditSessionId = audiSessionId;
         * this.epsStatus = epsStatus; this.securityGroup = securityGroup; this.nasIp = nasIp; this.postureStatus =
         * postureStatus; this.postureTimestamp = postureTimestamp;
         */

    }

    public String getUserName() {
        return userName;
    }

    public String getSessionState() {
        return sessionState;
    }

    @Override
    public int compareTo(SessionAttributes o) {
        if (this == o) {
            return 0;
        }
        // Null is considered less than any object.
        if (o == null) {
            return 1;
        }

        // Use compareToIgnoreCase since you used equalsIgnoreCase in equals.

        int diff = userName.compareToIgnoreCase(o.userName);
        if (diff != 0)
            return diff;

        diff = sessionState.compareToIgnoreCase(o.sessionState);
        return diff;
    }

    // public int compareTo(SessionAttributes o) {
    // // TODO Auto-generated method stub
    // if (this.getUserName().equals(o.getUserName()) && this.getSessionState().equalsIgnoreCase(o.getSessionState())) {
    // return 0;
    // }
    // return -1;
    // }

    public String toString() {

        return "\n User Name : " + this.getUserName() + " Session State : " + getSessionState() + "\n";
    }

    // public boolean equals(SessionAttributes obj) {
    //
    // if (obj == null || !(obj instanceof SessionAttributes)) {
    // return false;
    // }
    // System.out.println(" In equals==");
    // boolean isSameUserName = obj.userName.equalsIgnoreCase(this.userName);
    // boolean isSameState = obj.sessionState.equalsIgnoreCase(this.sessionState);
    // return (isSameUserName && isSameState);
    // }

    public boolean equals(Object o) {
        // See if o is the same object. If it is, return true.
        if (o == this) {
            return true;
        }

        // The instanceof check also checks for null. If o is null, instanceof will be false.
        if (!(o instanceof SessionAttributes)) {
            return false;
        }

        SessionAttributes that = (SessionAttributes) o;
        return userName.equalsIgnoreCase(that.userName) && sessionState.equalsIgnoreCase(sessionState);
    }

    public int hashCode() {

        System.out.println(" in hashcode ");
        int hash = 1;
        // Since in equals you are comparing for equality and ignoring case, you must convert the Strings to either
        // lower
        // or upper case when computing the hashCode so that it will always be consistent with equals.
        hash = hash * 17 + this.getUserName().toUpperCase().hashCode();
        hash = hash * 31 + this.getSessionState().toUpperCase().hashCode();
        // hash = hash * 13 + this.getAuditSessionId().hashCode();
        System.out.println(" hash=>" + hash);
        return hash;
    }

    public static void main(String[] args) {
        // sortSet();
        // sortLists();

        // expectedSessionList
        List<SessionAttributes> expectedSessionList = new ArrayList<SessionAttributes>();

        SessionAttributes user11 = new SessionAttributes("postureuser1", "STARTED"); //
        // ,null,null,null,null,null,null,null,null);

        SessionAttributes user12 = new SessionAttributes("postureuser1", "DISCONNECTED");

        SessionAttributes user13 = new SessionAttributes("postureuser5", "STARTED");

        expectedSessionList.add(user11);
        expectedSessionList.add(user12);
        expectedSessionList.add(user13);

        System.out.println("expectedSessionList: " + expectedSessionList);

        // actualSessionList
        List<SessionAttributes> actualSessionList = new ArrayList<SessionAttributes>();

        SessionAttributes user3 = new SessionAttributes("postureuser1", "STARTED");
        // ,null,null,null,null,null,null,null,null);

        SessionAttributes user4 = new SessionAttributes("postureuser1", "DISCONNECTED");

        SessionAttributes user5 = new SessionAttributes("postureuser2", "DISCONNECTED");

        // ,null,null,null,null,null,null,null,null);

        actualSessionList.add(user3);
        actualSessionList.add(user4);
        actualSessionList.add(user5);

        System.out.println("actualSessionList: " + actualSessionList);

        // removeDups
        // Use a TreeSet to sort it.
        Set<SessionAttributes> removeDups = new TreeSet<SessionAttributes>();

        boolean b1 = removeDups.add(user11);
        boolean b2 = removeDups.add(user12);
        boolean b3 = removeDups.add(user13);
        boolean b4 = removeDups.add(user3);
        boolean b5 = removeDups.add(user4);
        boolean b6 = removeDups.add(user5);

        System.out.println(" Set--" + removeDups);

        actualSessionList.removeAll(expectedSessionList);
        System.out.println("actualSessionList after removeAll: " + actualSessionList);

    }

}