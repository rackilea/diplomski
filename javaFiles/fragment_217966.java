class ClassA {

    var iWantToUseThisFromTheInnerClass = "someValue"

    fun runThisToStart() {
        val classB = ClassB(InnerClassA::class.java)
        classB.doSomething(this)

    }

    inner class InnerClassA(text: String) {
        init {
         //   Log.d("InnerClassA", "Constructor invoked " + text)
        }
    }

}

class ClassB<T>(private var mModelClass: Class<T>) {

    val someText = "whatever"

    fun doSomething(enclosingObj : Any):T {
            val constructor = mModelClass.getConstructor(enclosingObj::class.java, String::class.java)
            return constructor.newInstance(enclosingObj, someText)
    }

}