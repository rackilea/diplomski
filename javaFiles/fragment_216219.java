// Did we find the key in the word?
    boolean found = false;
    // Look at all of the characters.
    for (int z = 0; z < theWordChars.length; z++) {
        // Did they press this one?
        if (lastKey == theWordChars[z]) {
            // YES! Mark it as found.
            keyIsFound[z] = true;
            // Remember we found one so we don't add a body part.
            found = true;
        }
    }
    if ( !found ) {
        // Not found the key they pressed - add a body part.
    }