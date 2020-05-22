private void unsetB(final Note note) {
    this.presenter.performBoxOperation(note, false, new AsyncCallback<Note>() {
        // ...
        @Override
        public void onSuccess(Note result) {
            note.setB(false);  // set B value or copy `result` to `note`
                               // (`note` must be final)
            myDataProvider.flush();
            myTable.redraw();
        }
    });
}