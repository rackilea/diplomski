@Column 
private String hashedPassword; 

public String getHashedPassword() 
{
    return hashedPassword;
}

public void setHashedPassword( String hashedPassword ) 
{
    this.hashedPassword = hashedPassword;
} 

public String setUnhashedPassword( String unhashedPassword ) //no getter!
{
    String temp = hashPw( unhashedPassword );
    setHashedPassword( temp );
}