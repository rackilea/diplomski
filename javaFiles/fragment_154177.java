int Integrity_Voildation_ERROR=3;
 public void create(User team) throws DAOException
    {       
        try
        {
            System.out.println("Attempting to create an user - yikes the user already exists!");
            throw new SQLIntegrityConstraintViolationException();           
        }
        catch(SQLIntegrityConstraintViolationException e)
        {   int errorCode=Integrity_Voildation_ERROR;
            throw new DAOException(Integrity_Voildation_ERROR,"user is already found",e);
        }
}