public void checkUserId()
{
    ...
    ...
    if (getUserN().trim().length() < 1)
    {
        setMessage("User Id required");
    }
    else
    {
        ...
        ...
        else
        {
            setValidUserId(true);
            setUserIdExists(false);
            getUserNameInputT().requestFocus();
            setMessage("Please Enter User Details");
        }
    }
}