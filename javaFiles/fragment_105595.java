class ReduceComplexComponent : LifecycleObserver{

    registerLifecycle(lifecycle : Lifecycle){
       lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resume() {
       Log.d("OnResume","ON_RESUME")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun pause() {
       Log.d("onPause","ON_PAUSE")
    }
}