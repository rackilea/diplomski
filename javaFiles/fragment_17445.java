private class ProgressCell extends TreeTableCell<Employee, String> {

    final ProgressBar progress = new ProgressBar();

        ProgressCell() {
        }

        @Override
        protected void updateItem(String t, boolean empty) {
            super.updateItem(t, empty);
            if (!empty) {
                setGraphic(progress);
            }
    }
}