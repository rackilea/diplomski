synchronized(mReactInstanceManager!!.currentReactContext!!) {
    val nativeModuleRegistryBuilder = NativeModuleRegistryBuilder(
        mReactInstanceManager!!.currentReactContext as ReactApplicationContext?, 
        mReactInstanceManager!!, 
        false
    )

    nativeModuleRegistryBuilder.processPackage(packageToInject)
    mReactInstanceManager!!.currentReactContext!!.catalystInstance!!.extendNativeModules(nativeModuleRegistryBuilder.build())
}