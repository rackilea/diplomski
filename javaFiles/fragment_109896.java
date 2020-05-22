try {    
    Connection connection = ConnectionFactory.createConnection(conf);
}
catch (Exception e) //Replace Exception with the exception thown by ConnectionFactory 
{
... Do something.
}