open class Something {
    open fun beforeSaveEventApplicationListener(): ApplicationListener<BeforeSaveEvent> {
        return object : ApplicationListener<BeforeSaveEvent> {
            override fun onApplicationEvent(event: BeforeSaveEvent) {
                //Do something with event
            }
        }
    }
}