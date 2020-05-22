static boolean win(List<String> oFields) {
    for (String[] positions : WIN_COMB) {
        if (oFields.containsAll(Arrays.asList(positions)))
            return true;
    }
    return false;
}