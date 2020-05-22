public class UserId implements Serializable {

    private String username;

    private Integer countyId;

    // getter's and setter's

    public boolean equals(Object o) {

        if(o == null)
            return false;

        if(!(o instanceof UserId))
            return false;

        UserId id = (UserId) o;
        if(!(getUsername().equals(id.getUsername()))
            return false;

        if(!(getCountyId().equals(id.getCountyId()))
            return false;

        return true;
    }

    public int hachcode() {
       // hashcode
    }

}