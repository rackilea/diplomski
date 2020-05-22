val MY_CUSTOM_EVENT =
    EventType<Event>(Event.ANY, "MY_CUSTOM_EVENT" + UUID.randomUUID().toString())
var onOnlineClick = object : SimpleObjectProperty<EventHandler<Event>>() {
    override fun getBean(): Any {
        return this
    }

    override fun getName(): String {
        return "onMyCustomEvent"
    }

    override fun invalidated() {
        setEventHandler(MY_CUSTOM_EVENT, get())
    }
}

fun onMyCustomEvent(): ObjectPropertyBase<EventHandler<Event>> {
    return onMyCustomEvent
}

fun setOnMyCustomEvent(value: EventHandler<Event>) {
    onMyCustomEvent.set(value)
}

fun getOnMyCustomEvent(): EventHandler<Event> {
    return onMyCustomEvent.get()
}