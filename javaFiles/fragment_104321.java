public boolean isEqual(ArrayList<?> a, ArrayList<?> b) {
    if (a.size() != b.size())
        return false;

    for (int i = 0; i < a.size(); i++) {
        if (!isEqual((ArrayList<?>)a.get(i), (ArrayList<?>)b.get(i))) {
            return false;
        }
    }
    return true;
}