private val sampleClasses: MutableMap<Class<*>, KotlinSampleClass<*, *>> = mutableMapOf()

fun registerKotlinSampleClass(kotlinSampleClass: KotlinSampleClass<*, *>) {
    sampleClasses.put(kotlinSampleClass.type, kotlinSampleClass)
}

@Suppress("UNCHECKED_CAST")
fun callMethod(obj : Any) {
    (sampleClasses[obj.javaClass] as KotlinSampleClass<Any, *>?)?.callMethod(obj)
}