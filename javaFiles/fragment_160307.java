import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetData {

    /**
     * _id : store_1000023
     * _rev : 87-d1e87e9b6b350666bd19f5455553a16e4c241e07
     * channels : ["1000023"]
     * commander : {"ipAddress":"18.215.105.64","keychainID":"6866A0A0_77E4_4B64_AAE3_7FEBDA0C8745","lastUpdatedDate":"2019-05-20T14:29:45.220Z","oldPasswords":["Y2N8B7K","h0Y7I2c","P5q6N5r","y0C6s7M","O2G4u8q"],"password":"O2G4u8q","userName":"kwikrun"}
     * companyID : 1000023
     * createdDate : 2018-12-29T08:01:52.248Z
     * isAllowNewDevice : false
     * isStoreSetup : true
     * type : stores
     * updatedDate : 2019-05-21T09:25:22.314Z
     */

    @SerializedName("_id")
    private String id;
    @SerializedName("_rev")
    private String rev;
    @SerializedName("commander")
    private CommanderBean commander;
    @SerializedName("companyID")
    private String companyID;
    @SerializedName("createdDate")
    private String createdDate;
    @SerializedName("isAllowNewDevice")
    private boolean isAllowNewDevice;
    @SerializedName("isStoreSetup")
    private boolean isStoreSetup;
    @SerializedName("type")
    private String type;
    @SerializedName("updatedDate")
    private String updatedDate;
    @SerializedName("channels")
    private ArrayList<String> channels;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRev() {
        return rev;
    }

    public void setRev(String rev) {
        this.rev = rev;
    }

    public CommanderBean getCommander() {
        return commander;
    }

    public void setCommander(CommanderBean commander) {
        this.commander = commander;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isIsAllowNewDevice() {
        return isAllowNewDevice;
    }

    public void setIsAllowNewDevice(boolean isAllowNewDevice) {
        this.isAllowNewDevice = isAllowNewDevice;
    }

    public boolean isIsStoreSetup() {
        return isStoreSetup;
    }

    public void setIsStoreSetup(boolean isStoreSetup) {
        this.isStoreSetup = isStoreSetup;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public ArrayList<String> getChannels() {
        return channels;
    }

    public void setChannels(ArrayList<String> channels) {
        this.channels = channels;
    }

    public static class CommanderBean {
        /**
         * ipAddress : 18.215.105.64
         * keychainID : 6866A0A0_77E4_4B64_AAE3_7FEBDA0C8745
         * lastUpdatedDate : 2019-05-20T14:29:45.220Z
         * oldPasswords : ["Y2N8B7K","h0Y7I2c","P5q6N5r","y0C6s7M","O2G4u8q"]
         * password : O2G4u8q
         * userName : kwikrun
         */

        @SerializedName("ipAddress")
        private String ipAddress;
        @SerializedName("keychainID")
        private String keychainID;
        @SerializedName("lastUpdatedDate")
        private String lastUpdatedDate;
        @SerializedName("password")
        private String password;
        @SerializedName("userName")
        private String userName;
        @SerializedName("oldPasswords")
        private ArrayList<String> oldPasswords;

        public String getIpAddress() {
            return ipAddress;
        }

        public void setIpAddress(String ipAddress) {
            this.ipAddress = ipAddress;
        }

        public String getKeychainID() {
            return keychainID;
        }

        public void setKeychainID(String keychainID) {
            this.keychainID = keychainID;
        }

        public String getLastUpdatedDate() {
            return lastUpdatedDate;
        }

        public void setLastUpdatedDate(String lastUpdatedDate) {
            this.lastUpdatedDate = lastUpdatedDate;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public ArrayList<String> getOldPasswords() {
            return oldPasswords;
        }

        public void setOldPasswords(ArrayList<String> oldPasswords) {
            this.oldPasswords = oldPasswords;
        }
    }
}