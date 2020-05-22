package kotlin.jvm.functions

interface FunctionN<out R> : kotlin.Function<R> {
    val arity: Int
    fun invokeVararg(vararg p: Any?): R
}