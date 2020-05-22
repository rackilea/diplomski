HighlightPredicate predicate = new HighlightPredicate() {

        @Override
        public boolean isHighlighted(Component renderer,
                ComponentAdapter adapter) {

            return 
               adapter.convertRowIndexToModel(adapter.row) == mySpecialRow;
        }

    };