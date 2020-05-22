public BinaryTree plantTree(ArrayList<String> dict) {

    tree = new BinaryTree(); // important!

    Collections.shuffle(dict);

    for (String s : dict) {
        s.toUpperCase();
        System.out.print(s);
        tree.add(s);
    }

    System.out.print(tree);
    System.out.println();
    return tree;

}