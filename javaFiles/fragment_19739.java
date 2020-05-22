//In FileUploadServletAction
private File userKey;  //file name which is on JSP
private String userKeyContentType;
private String userKeyFileName;  

//getter, setter  
public File getUserKey() 
{
    return userKey;
}

public void setUserKey(File userKey) 
{
    this.userKey = userKey;
}

public String getUserKeyFileName()
{
    return userKeyFileName;
} 

public String getUserKeyContentType() 
{
    return userKeyContentType;
}

public void setUserKeyContentType(String userKeyContentType)
{
    this.userKeyContentType = userKeyContentType;
}

public void setUserKeyFileName(String userKeyFileName)
{
    this.userKeyFileName = userKeyFileName;
}