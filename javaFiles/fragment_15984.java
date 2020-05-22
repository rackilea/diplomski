private Map<Character, String> genMap(HuffmanNode root) {
    Map<Character, String> map = new HashMap<Character, String>();
    huffmanTreeAdd(map, root, "");
    return map;
}

private void huffmanTreeAdd(Map<Character, String> map, HuffmanNode root, String path) {
    if (root.isLeaf()) {
        map.put(root.character, path);
    }
    else {
        huffmanTreeAdd(map, root.left, path + '0');
        huffmanTreeAdd(map, root.right, path + '1');
    }
}