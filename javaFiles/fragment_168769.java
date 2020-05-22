SELECT ?res ?belongs ?adminUnit
WHERE  {
           ?res a geo:Municipality ;
                geo:έχει_επίσημο_όνομα "ΔΗΜΟΣ ΧΑΝΙΩΝ" ;
                geo:belongsTo+ ?belongs .
           ?belongs a ?adminUnit .
}