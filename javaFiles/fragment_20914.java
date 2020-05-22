// sender (activity or other)
EventBus.getDefault().post(new ClickEvent(index));

// receiver (fragments, or other)
EventBus.getDefault().register(this); // in onCreate()
EventBus.getDefault().unregister(this); // in onDestroy()
public void onEvent(ClickEvent clickEvent) { ... }