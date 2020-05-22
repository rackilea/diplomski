ArrayList<Tree> trees = new ArrayList<Tree>();

        int treeCount = 10;
        for (int i = 0; i < treeCount; i++) {
            double suitability = Math.random();
            int id = i;
            // We create the Tree...
            Tree tree = new Tree(space, grid, suitability, id);
            // ... then add it to the context
            context.add(tree);
            // ... then add it to the list
            trees.add(tree);