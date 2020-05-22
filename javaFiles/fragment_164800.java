private class ModelListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            IndexedPropertyChangeEvent iEvt = (IndexedPropertyChangeEvent)evt;
            int index = iEvt.getIndex();
            int row = index / Model.COLS;
            int col = index % Model.COLS;
            Token token = (Token) evt.getNewValue();

            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {

                    view.setCell(token, row, col);
                    CellsList path = model.getPath();
                    //ignore path if null, empty or encloses no cell
                    if((path == null) || path.isEmpty()
                                        || model.getContainedWithin().isEmpty()) {
                        return;
                    }
                    view.addPath(path);
                    view.refresh();
                }
            });
        }
    }