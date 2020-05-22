class ReactManagerPackage : ReactPackage {
    override fun createViewManagers(reactContext: ReactApplicationContext): List<ViewManager<*, *>> {
        return emptyList()
    }

    override fun createNativeModules(reactContext: ReactApplicationContext): List<NativeModule> {
        val modules = ArrayList<NativeModule>()
        modules.add(ReactBridge(reactContext))
        return modules
    }
}

class ReactBridge(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {
    override fun getName(): String {
        return myFragmentOrActivity.hashCode().toString()
    }

    @ReactMethod
    fun showToast(text: String) {
        Toast.makeText(text, Toast.LENGTH_SHORT).show()
    }  
}