S1: Lookup for some input data
S2:  IF not found {
       synchronized(getClass()) {
S2-1:    Lookup for some input data
S2-2:    IF not found
S2-3:    INSERT DATA
       }
S3:  RETURN result of S1, S2-1, or S2-3