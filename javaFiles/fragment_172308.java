for (int i = 0; i < n; i++) { //use n instead of N because of java conventions
        int input=in.nextInt();
        Node theNewLastNodeInTheList = new Node(input);
        currentNode.next = theNewLastNodeInTheList;
        currentNode = theNewLastNodeInTheList;
    }