...
    for (int k = 0; k < sortByNodes.getLength(); k++) {
        Node sortBy = sortByNodes.item(k);

        if(sortBy.getNodeName().equals("sort_by_letter")) {
            System.out.println("SORT BY: " + sortBy.getNodeName());
            ...