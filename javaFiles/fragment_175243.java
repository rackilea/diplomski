data.sort((o1, o2) -> {
    if (greaterThan.getOrDefault(o1, Collections.emptySet()).contains(o2))
        return 1;
    else if (greaterThan.getOrDefault(o2, Collections.emptySet()).contains(o1))
        return -1;
    return 0;
});