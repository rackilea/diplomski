current_character = getNextCharacter();
if (current_character == BACKSLASH) {
    current_character = getNextCharacter();
    if (current_character == 'n') {
        /*oh, they want a newline */
    } else if (current_character == 't') {
        /* it's a tab they want */
    } else /* ... and so on and so forth */
}