private void dispatchEvents() {
    isDispatching.set(true);
    while (!consumedEvents.isEmpty()) {
        MotionEntry entry = consumedEvents.poll();

        ViewGroup parent = (ViewGroup) entry.view.getParent();
        if (parent == null || entry.view.getVisibility() != View.VISIBLE) {
            continue; // skip dispatching to detached/invisible view
        }
        // make position relative to parent...
        entry.event.offsetLocation(entry.view.getLeft(), entry.view.getTop());
        entry.event.setSource(PARENT_DISPATCHER);
        parent.dispatchTouchEvent(entry.event);

        if (event.getActionMasked() == MotionEvent.ACTION_UP) {
            clickListener.onClick(entry.view);
        }
    }
    isDispatching.set(false);
}