if (bSearch instanceof BruteForceSearch) {
    BruteForceSearch search = (BruteForceSearch) bSearch;
    // perform brute force specific calls, e.g. search.setMaxTimeSeconds(100);
} else if (bSearch instanceof RegExSearch) {
    RegExSearch search = (RegExSearch) bSearch;
    // perform regular expression specific calls
}