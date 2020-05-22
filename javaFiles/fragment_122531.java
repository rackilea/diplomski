for (int i=0; i<n-(2*m)+1; i++) { // use `*`
         // again use `*` also how to compare String - use equals
        if (sr.substring(i, i+m).equals (sr.substring(i+m, i+2 *m))) {  
            return false;
        }
    }