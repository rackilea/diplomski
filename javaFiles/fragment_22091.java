Tree<String> forest = new Tree<String>("forest");
    Tree<String> current = forest;

    for (String tree : Arrays.asList("x1/x2/x3", "x1/x2/x4", "x1/x5")) {
        Tree<String> root = current;

        for (String data : tree.split("/")) {
            current = current.child(data);
        }

        current = root;
    }

    forest.accept(new PrintIndentedVisitor(0));