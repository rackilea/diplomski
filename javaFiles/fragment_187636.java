private final Queue<MotionEntry> consumedEvents = new LinkedList<>();
private final AtomicBoolean isDispatching = new AtomicBoolean(false);
...
    groupView.setOnTouchListener(new OnTouchListener() {
        @Override 
        public boolean onTouch(View v, MotionEvent e) {
            // we don't want to handle re-dispatched event...
            if (isDispatching.get()) {
                return false; 
            }
            // create clone as event might be changed by parent
            MotionEvent clone = MotionEvent.obtain(e);
            MotionEntry entry = new MotionEntry(v, clone);
            consumedEvents.add(entry);

            // consume ACTION_DOWN in order to receive subsequent motion events 
            // like ACTION_MOVE, ACTION_CANCEL/ACTION_UP...
            if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                return true;
            }
            // we do not want to handle canceled motion...
            if (event.getActionMasked() == MotionEvent.ACTION_CANCEL) {
                consumedEvents.clear();
                return false;
            }
            // at this moment we have intercepted whole motion 
            // = re-dispatch to parent in order to apply default handling...
            if (event.getActionMasked() == MotionEvent.ACTION_UP) {
                dispatchEvents();
            }
            return true;
        }
    });
...