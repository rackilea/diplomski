inline fun <reified T> required(): ReadWriteProperty<Any, T> {
    return object : ReadWriteProperty<Any, T> {
        var value: T? = null;
        override fun getValue(thisRef: Any, property: KProperty<*>): T = value as T

        override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
            this.value = value;
        }

    }
}