fun myProperty(): BooleanProperty {
    return myCustomProperty ?: run {
        myCustomProperty = object : SimpleBooleanProperty(false) {
            override fun invalidated() {
                fireEvent(Event(MY_CUSTOM_EVENT)) // <---this
            }

            override fun getBean(): Any {
                return this
            }

            override fun getName(): String {
                return "myProperty"
            }
        }
        return myCustomProperty as SimpleBooleanProperty
    }
}