class Outer {
    val insideInner: Inner = InnerImpl()

    interface Inner {
        // ...
    }
    private inner class InnerImpl : Inner {
        // ...
    }
}


val outer = Outer()
val outsideInner = outer.InnerImpl() // Error! Cannot access '<init>': it is private in 'Inner'