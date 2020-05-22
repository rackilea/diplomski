@OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
public void appInResumeState() {
    Toast.makeText(this,"In Foreground",Toast.LENGTH_LONG).show();
}

@OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
public void appInPauseState() {
    Toast.makeText(this,"In Background",Toast.LENGTH_LONG).show();
}