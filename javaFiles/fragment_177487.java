public void addUPI(String pwd, Timestamp pwdTS, Boolean pwdChng){
    UserPasswordInfo upi = new UserPasswordInfo();
    upi.setPassword(pwd);
    upi.setPasswordTS(pwdTS);
    upi.setPwdChange(pwdChng);
    if(getId() != null)
        upi.setUserId(getId().intValue());
    passwordInfos.add(upi);
}