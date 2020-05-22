public class EmailStatusCheckJson
{
    private Boolean emailIsAvailable;

    public Boolean getEmailIsAvailable()
    {
        return emailIsAvailable;
    }

    public void setEmailIsAvailable(
        final Boolean newValue)
    {
        emailIsAvailable = newValue
    }
}


@RequestMapping(value="/checkEmailUnique",method=RequestMethod.POST)
public EmailStatusCheckJson checkEmailUnique(@RequestBody final String username)
{
    final EmailStatusCheckJson returnValue = new EmailStatusCheckJson();

    if (...) // email is available.
    {
        returnValue.setEmailIsAvailable(true);
    }
    else
    {
        returnValue.setEmailIsAvailable(false);
    }

    return returnValue;        
}