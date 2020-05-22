catch(RuntimeException r)
{
     if(r instanceof SomeRunTimeException)
       throw null; 
       else throw r;
}
catch(Exception e) 
{
     throw e;
}