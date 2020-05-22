if (Array.getLength(first) != Array.getLength(second))
        return false;

    for (int i = 0; i < Array.getLength(first); ++i) {
        Object firstItem = Array.get(first, i);
        Object secondItem = Array.get(second, i);
        if (!(firstItem == null ? secondItem == null : firstItem.equals(secondItem)))
            return false;
    }
    return true;