public static <T> T betterEllement(T s1, T s2, BiPredicate<T, T> bi) {
    if (bi.test(s1, s2)) {
        return s1;
    } else {
        return s2;
    }
}