viewer.addCheckStateListener(new ICheckStateListener() {
        @Override
        public void checkStateChanged(CheckStateChangedEvent event) {
            // event.getChecked() is the check state
            // event.getElement() is element being checked/unchecked
        }
    });