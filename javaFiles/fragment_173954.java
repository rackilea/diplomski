if ( loan < 1000 ) {
    f = (loan * 100 / 1000);
    System.out.println( "The loan amount is $" + loan );
    System.out.println( "The finance charge is $" + f );
    System.out.println( "The total cost is $" + (loan + f) );
}