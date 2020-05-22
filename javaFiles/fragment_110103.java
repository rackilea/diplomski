// s must not be null
public boolean isAbecedarianrec(String s) {
    return isAbecedarianRecImpl(s, (char)0);
}

private boolean isAbecedarianRecImpl(String s, char c) {
    if (s.isEmpty())
        return true;
    else {
        if (c > s.charAt(0))
            return false;
        else
            return isAbecedarianRecImpl(s.substring(1), s.charAt(0));
    }
}