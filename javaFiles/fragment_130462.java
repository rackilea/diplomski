open = new PriorityQueue<Cell>(new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return c1.endCost < c2.endCost ? -1 :
                        c1.endCost > c2.endCost ? 1 : 0;
            }
        });