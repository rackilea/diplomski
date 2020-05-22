private CharProperty clazz(boolean consume) {
    // [Declaration and initialization of local variables - OMITTED]
    BitClass bits = new BitClass();
    int ch = next();
    for (;;) {
        switch (ch) {
            case '^':
                // Negates if first char in a class, otherwise literal
                if (firstInClass) {
                    // [CODE OMITTED]
                    ch = next();
                    continue;
                } else {
                    // ^ not first in class, treat as literal
                    break;
                }
            case '[':
                // [CODE OMITTED]
                ch = peek();
                continue;
            case '&':
                // [CODE OMITTED]
                continue;
            case 0:
                // [CODE OMITTED]
                // Unclosed character class is checked here
                break;
            case ']':
                // [CODE OMITTED]
                // The only return statement in this method
                // is in this case
                break;
            default:
                // [CODE OMITTED]
                break;
        }
        node = range(bits);

        // [CODE OMITTED]
        ch = peek();
    }
}