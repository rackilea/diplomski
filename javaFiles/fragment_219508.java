public Integer test(T m)                          
{
   if(m instanceof MessageA || m instanceof MessageB)  {                                            
        System.out.println( "A subclass of Message instance." );
        //your custom process
   }else{
        System.out.println( "A Message instance." );
        //your custom process
   }
}