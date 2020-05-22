for ( i=2 ; i<100 ; ++i )
{
    isprime = true ;
    for ( j=2 ; j<100 ; ++j )
    {
        if ( (i%j) == 0 )
        {
            isprime = false ;
            break ;
        }
    }

    if ( isprime )
    {
        System.out.println ( i + " is prime." ) ;
    }
}