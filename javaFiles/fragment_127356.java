private static List<Long> search(long value, List<Long> a) {
    if (a.size() < 3) return new ArrayList<>(a);
    List<Long> result = new ArrayList<>();
    if (value < a.get(0)) {
        result.add(a.get(0));
        result.add(a.get(1));
        return result;
    }
    if (value > a.get(a.size() - 1)) {
        result.add(a.get(a.size() - 2));
        result.add(a.get(a.size() - 1));
        return result;
    }

    int lo = 0;
    int hi = a.size() - 1;
    int match = -1;

    while (lo <= hi) {
        int mid = (hi + lo) / 2;
        if (value < a.get(mid)) {
            hi = mid - 1;
        } else if (value > a.get(mid)) {
            lo = mid + 1;
        } else {
            match = mid;
            break;
        }
    }

    if (match >= 0) {
        if (match > 1) result.add(a.get(match - 2));
        if (match > 0) result.add(a.get(match - 1));
        if (match < a.size() - 1) result.add(a.get(match + 1));
        if (match < a.size() - 2) result.add(a.get(match + 2));
    } else if (a.get(lo) < value) {
        result.add(a.get(hi));
        result.add(a.get(lo));
        if (lo < a.size() - 1) result.add(a.get(lo + 1));
        if (lo < a.size() - 2) result.add(a.get(lo + 2));
    } else if (a.get(hi) > value) {
        if (hi > 1) result.add(a.get(hi - 2));
        if (hi > 0) result.add(a.get(hi - 1));
        result.add(a.get(hi));
        result.add(a.get(lo));
    } else {
        if (hi > 0) result.add(a.get(hi - 1));
        result.add(a.get(hi));
        result.add(a.get(lo));
        if (lo < a.size() - 1) result.add(a.get(lo + 1));
    }

    return result;
}