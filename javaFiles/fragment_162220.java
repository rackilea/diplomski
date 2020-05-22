try
{
QueryExecution qe = query(string);
}
catch (HttpException ex)
{
System.out.println (ex.getMessage());   //Optional
ex.printStackTrace();    //Optional
}