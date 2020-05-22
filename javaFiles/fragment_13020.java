ArrayList<Node> nodes;
        Collections.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.getNodeName().compareTo(o2.getNodeName());
            }
        });