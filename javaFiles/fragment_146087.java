public static boolean isValidPiecePlacement(String piecePlacementString) {
    if (piecePlacementString == null || piecePlacementString.length() == 0) {
        return false;
    }

    final char firstChar = piecePlacementString.charAt(0);

    if (firstChar >= 'A' && firstChar <= 'G') {
        // make other comparisons
        return true;
    }
    return false;
}