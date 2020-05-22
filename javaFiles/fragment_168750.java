for (Object cell : IteratorUtil.asIterable(result.columnAs("result"))) {
            Iterable<Node> nodes = (Iterable<Node>) cell;
            for (Node n : nodes) {
                System.out.println(n);
            }
        }