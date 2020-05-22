Lets understand using an example.

try
{
       //Do some processing which throws NullPointerException; I am sending directly
       throw new NullPointerException();
}

//You can catch multiple exception added after 'pipe' character
catch(NullPointerException | IndexOutOfBoundsException ex)
{
       throw ex;
}