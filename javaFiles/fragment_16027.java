final String sentence;
    int mask = sentence.contains("abcd") ? 1 : 0;
    mask |= sentence.contains("efgh") ? 2 : 0;
    mask |= sentence.contains("ijkl") ? 4 : 0;
    switch (mask) {
    case 1:
    case 1 | 2:
    case 1 | 4:
    case 1 | 2 | 4:
        // do command a
        break;
    case 2:
    case 2 | 4:
        // do command b
        break;
    case 4:
        // do command c
        break;
    default:
        // do command d
    }
}