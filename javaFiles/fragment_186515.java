Node node = new Node(fileScanner.nextLine())
    // If the node is a question, it should have 2 subnodes with the answers / nested questions.
    if(line.contains("?")){
        node.setLeft(fileToTreeHelper(...));
        // If there is an option that has only 1 answer, then this should have an if that
        // checks if there is a ";" and then create the node or set it as null.
        node.setRight(fileToTreeHelper(...));
    }
    // If it is not a question, then it's just an answer to a previous question and returns.
    return node;