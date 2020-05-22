class MyEntity {}

open class Something {
    open fun beforeSaveEventApplicationListener(): ApplicationListener<BeforeSaveEvent<MyEntity>> {
        return object : ApplicationListener<BeforeSaveEvent<MyEntity>> {
            override fun onApplicationEvent(event: BeforeSaveEvent<MyEntity>) {
                //Do something with event
            }
        }
    }
}