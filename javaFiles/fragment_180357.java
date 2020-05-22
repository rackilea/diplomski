try
{    
    int i = 10/0 ;  
}
catch (Exception e)
{
    throw new RuntimeException(e);
}