public class DbDrivenPayloadHandlerBean {
int APPTS_FULLNAME_POS = -1;
int APPTS_DATETIME_POS = -1;


public DbDrivenPayloadHandlerBean() {
    super();
}

public int getAPPTS_FULLNAME_POS() {
    return APPTS_FULLNAME_POS;
}

public void setAPPTS_FULLNAME_POS(int APPTS_FULLNAME_POS) {
    this.APPTS_FULLNAME_POS = APPTS_FULLNAME_POS;
}   

public int getAPPTS_DATETIME_POS() {
    return APPTS_DATETIME_POS;
}

public void setAPPTS_DATETIME_POS(String APPTS_DATETIME_POS) {
    this.APPTS_DATETIME_POS = APPTS_DATETIME_POS;
}