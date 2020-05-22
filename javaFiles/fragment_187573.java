for (int i = 0; i < al.size() - 3; i += 5) {
    if (i + 4 < al.size() && al.get(i + 4) != null) {
        ... // Use al.get(i + 4)
    } else {
        ... // Don't use it
    }
}