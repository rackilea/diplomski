set.removeIf(item -> {
    if (!item.qualify())
        return false;
    item.operate();
    return true;
});