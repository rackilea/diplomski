public boolean isAllStrange(List<? extends Strange> strangeCollection) {
    for (Strange object : strangeCollection) {
        if (object.isStrange())
            return true;
    }
    return false;
}