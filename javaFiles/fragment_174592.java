private CharProperty clazz(boolean consume) {
    CharProperty prev = null;
    CharProperty node = null;
    BitClass bits = new BitClass();
    boolean include = true;
    boolean firstInClass = true;
    int ch = next();
    for (;;) {
        switch (ch) {
            case '^':
                // Negates if first char in a class, otherwise literal
                if (firstInClass) {
                    if (temp[cursor-1] != '[')
                        break;
                    ch = next();
                    include = !include;
                    continue;
                } else {
                    // ^ not first in class, treat as literal
                    break;
                }
            case '[':
                firstInClass = false;
                node = clazz(true);
                if (prev == null)
                    prev = node;
                else
                    prev = union(prev, node);
                ch = peek();
                continue;
            case '&':
                // [CODE OMITTED]
                // There are interesting things (bugs) here,
                // but it is not relevant to the discussion.
                continue;
            case 0:
                firstInClass = false;
                if (cursor >= patternLength)
                    throw error("Unclosed character class");
                break;
            case ']':
                firstInClass = false;

                if (prev != null) {
                    if (consume)
                        next();

                    return prev;
                }
                break;
            default:
                firstInClass = false;
                break;
        }
        node = range(bits);

        if (include) {
            if (prev == null) {
                prev = node;
            } else {
                if (prev != node)
                    prev = union(prev, node);
            }
        } else {
            if (prev == null) {
                prev = node.complement();
            } else {
                if (prev != node)
                    prev = setDifference(prev, node);
            }
        }
        ch = peek();
    }
}