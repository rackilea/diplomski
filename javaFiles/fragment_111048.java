public static boolean listEndsWith(List<?> A, List<?> B) {
    if (B.size() > A.size()) {
        return false;
    }

    for (int i = A.size() - B.size(), j = 0; i < A.size(); i++, j++) {
        if (!A.get(i).equals(B.get(j))) {
            return false;
        }
    }

    return true;
}