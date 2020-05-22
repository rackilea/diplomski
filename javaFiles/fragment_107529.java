class InterfaceProvider (private val context: Context): Provider<Interface> {

    companion object {
        private var instance: Interface? = null
    }

    override fun get(): Interface {
        if (instance == null) {
            instance = InterfaceImpl(context)
        }
        return instance!!
    }
}