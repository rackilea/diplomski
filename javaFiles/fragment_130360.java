abstract class Base() {

    protected fun init(): Base {
        // do the initialization
        return this
    }
}

class A : Base() {
    companion object {
        fun create() = A().init() as A
    }
}