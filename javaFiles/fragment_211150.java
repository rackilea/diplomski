class Foo private constructor(val someData: Data) {
    companion object {
        operator fun invoke(): Foo {
            // do stuff

            return Foo(someData)
        }
    }
}

//usage
Foo() //even though it looks like constructor, it is a function call