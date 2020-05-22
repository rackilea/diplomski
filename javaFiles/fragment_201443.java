ObservableList<Item> items = FXCollections.observableArrayList();
items.addListener((ListChangeListener.Change<? extends Item> c) -> {
    boolean hadNext;
    while ((hadNext = c.next()) && c.wasPermutated()) {
        int to = c.getTo();
        for (int i = c.getFrom(); i < to; i++) {
            items.get(i).index.set(i);
        }
    }

    while (hadNext) {
        if (c.wasReplaced()) {
            int to = c.getTo();
            for (int i = c.getFrom(); i < to; i++) {
                items.get(i).index.set(i);
            }
        } else {
            if (!c.wasUpdated()) {
                // add/remove change
                int to = items.size();
                for (int i = c.getFrom(); i < to; i++) {
                    items.get(i).index.set(i);
                }
            }
            break;
        }
        hadNext = c.next();
    }

});