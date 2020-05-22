public class StripperBean {

    public StripperBean(int stripperID, String stripperName, String realName) {
        this.stripperID = stripperID;
        this.stripperName = stripperName;
        this.realName = realName;
    }

    private int stripperID; 
    private String stripperName;
    private String realName;        

    public int getStripperID() {
        return stripperID;
    }
    public void setStripperID(int stripperID) {
        this.stripperID = stripperID;
    }
    public String getStripperName() {
        return stripperName;
    }
    public void setStripperName(String stripperName) {
        this.stripperName = stripperName;
    }
    public String getRealName() {
        return realName;
    }
    public void setRealName(String realName) {
        this.realName = realName;
    }       
}