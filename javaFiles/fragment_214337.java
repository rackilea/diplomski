public boolean findWordOnBoard(String word, Tile tile, int depth, HashSet<Integer> visited) {
    if (depth == word.length()) return true; // base case - breaks recursion (on board)
    else {
        word = word.toUpperCase();
        if (tile == null) return false;
        HashSet<Integer> neighbors = map.get(tile.getPlace());
        for (int n : neighbors) {
            if (depth >= word.length()) return true;
            if ((tiles[n-1].getChar() == word.charAt(depth)) && (!visited.contains(n))) {
                visited.add(n);
                System.out.println("found " + tile.getChar() + " at " + n);
                return findWordOnBoard(word, tiles[n-1], depth+1, visited);
            } 
        }

    }
    return false; //will only get here if it doesn't find a new word
}