switch (x) {
    case 1:
       if (...) {
         switch (.) {
            ...
         }
       } else {
         ...
       }
    case -1:
       /*UNREACHABLE*/
       throw new RuntimeException("nope");

    case 2:
       ...
}