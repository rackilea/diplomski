private boolean preRequisitesControl() 
{
    return checkEnvironment() 
           && validateRunContext() 
           && checkLockFile();   
}