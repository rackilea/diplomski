public List<RelasiRumahKayuRangka>
   getRelasiByIdRangka( String idRangka ) throws Exception {
    initEntityManager();
    // rest of the code here
    // ...

    // check if some results are found or not
    if( rrDrs.isEmpty() ) { // or ( rrDrs.size() == 0 )
       throw new NoResultException( "No results found" );
    } // if empty

    // this should be a filled in list
    return rrDrs;
} // end of method