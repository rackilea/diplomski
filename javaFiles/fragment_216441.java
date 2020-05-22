while ( '123456' =~ /(?=(\d{3}))(?=(\d{4}))?(?=(\d{5}))?/g )
{
     print "$1\n";
     if ( length ($2) ) {
         print "$2\n";
     }
     if ( length ($3) ) {
         print "$3\n";
     }
}