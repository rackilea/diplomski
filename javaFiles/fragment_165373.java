private long lengthOfMyFile; // with Getter

public String execute(){
    /* file loading and stuff ... */
    lengthOfMyFile = myFile.length();
    return SUCCESS;
}