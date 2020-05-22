Class Result implements IResult{

    private boolean isSuccess;
    private int errorCode;
     private String errorMessage;
     private Exception originalException;//this might be optional to put here.
    }


So a DAO API:
    public IResult create(User team) throws DAOException
    {      
   IResult result=new Result();
        try
        {
            System.out.println("Attempting to create an user - yikes the user already exists!");
            throw new SQLIntegrityConstraintViolationException();           
        }
        catch(SQLIntegrityConstraintViolationException e)
        {   int errorCode=Integrity_Voildation_ERROR;
            result.setSuccess(false);
        result.setErrorCode(errorCode);
        result.setErrorMessage("user is already found");    
        }
    return result;
}