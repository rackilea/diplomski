void onItemSelected(MenuItem menuItem) {
    runNow(new SelectedItemAnimationHandler(menuItem)); // Takes 500ms
    // Delay for 500ms to wait until end of selection anim.
    postDelayed(new ScreenTransitionOffHandler(currentMenu), 500); // Takes 1000ms
    // Delay for 1500ms to wait until end of transition off.
    postDelayed(new ScreenTransitionOnHandler(nextMenu), 1500);
}