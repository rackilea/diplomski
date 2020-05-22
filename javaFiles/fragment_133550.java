CollectionIterator<Integer> remove2 = new CollectionIterator<Integer>() {
        @Override
        public IterationResult onObject(Integer object) {
            return object == 2 ? IterationResult.REMOVE : IterationResult.NEXT;
        }
    };

    MyCollection<Integer> col = new MyCollection<>();

    CollectionModification<Integer> mod = col.startModification();
    try {
        mod.add(new Integer(1))
                .add(new Integer(2))
                .add(new Integer(3));
    } finally {
        col.finishModification();
    }

    col.iterate(remove2);