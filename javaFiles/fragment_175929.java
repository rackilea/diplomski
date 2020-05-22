List<Node> siblings = options.siblingNodes().subList(1, options.siblingNodes().size());

    Iterator<Node> sibIterator = siblings.iterator();

    while (sibIterator.hasNext()) {
        System.out.println(sibIterator.next().toString());
    }