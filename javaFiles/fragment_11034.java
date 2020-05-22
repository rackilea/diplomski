public void close () {
    Display.getDefault().asyncExec(new Runnable () {
        public void run () {
            getSite().getPage().closeEditor(YourEditorClass.this, false);
        }
    });
}