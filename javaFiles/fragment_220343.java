ObjectBinding<Predicate<Log>> binding = new ObjectBinding<Predicate<String>>() {
    private final Set<String> strings = new HashSet<>();

    {
        sourceList.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<String>() {

            @Override
            public void onChanged(ListChangeListener.Change<? extends String> c) {
                boolean changed = false;

                // modify set on selection change
                while (c.next()) {
                    if (c.wasRemoved()) {
                        changed = true;
                        c.getRemoved().stream().map(String::toLowerCase).forEach(strings::remove);
                    }
                    if (c.wasAdded()) {
                        changed = true;
                        c.getAddedSubList().stream().map(String::toLowerCase).forEach(strings::add);
                    }
                }

                if (changed) {
                    invalidate();
                }
            }
        });
    }

    @Override
    protected Predicate<Log> computeValue() {
        return log -> strings.contains(log.getSource().toLowerCase());
    }

};
sourceFilter.bind(binding);