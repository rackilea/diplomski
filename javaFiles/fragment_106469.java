public class Record {

private String iccid;
private String apn;
private String ipAddress;
private String pdp;
public String getIccid() {
    return iccid;
}
public void setIccid(String iccid) {
    this.iccid = iccid;
}
public String getApn() {
    return apn;
}
public void setApn(String apn) {
    this.apn = apn;
}
public String getIpAddress() {
    return ipAddress;
}
public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
}
public String getPdp() {
    return pdp;
}
public void setPdp(String pdp) {
    this.pdp = pdp;
}
public String toString() {
    return "Record [iccid=" + iccid + ", apn=" + apn + ", ipAddress="
            + ipAddress + ", pdp=" + pdp + "]";
}