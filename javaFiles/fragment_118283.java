boolean isValid = sSerials[nCtr].matches(
    "[0-9]{2}"        // Match 2 digits
        + "-"         // Then a dash
        + "[0-9]{4}"  // Then 4 digits
        + "\\."       // Then a dot (which must be escaped)
        + "[0-9]{4}"  // Then 4 digits
        + "[abc]{2}"  // Then 2 a, b or c.