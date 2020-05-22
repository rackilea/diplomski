void onItemSelected(MenuItem menuItem) {
    // Set up the actions
    // Actions call onCompleted() on any observers when they complete.
    SelectedItemAnimationAction sa = new SelectedItemAnimationAction(menuItem);
    ScreenTransitionOffAction stoff = new ScreenTransitionOffAction(currentMenu);
    ScreenTransitionOnAction ston = new ScreenTransitionOnAction(nextMenu);

    // Add some observers to the actions
    sah.addOnCompletedHandler(new ActionObserver() {
            public void onCompleted() {
                stoff.start();
            }
        });
    stoff.addOnCompletedHandler(new ActionObserver() {
            public void onCompleted() {
                ston.start();
            }
        });

    // Start the first action
    sa.start();
}