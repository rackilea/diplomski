package gradle.multi.application

import doSomething

fun main() {
    "12314".toInt() // check, that api layer is exposed here

    /* runBlocking { // this couldn't be compiled, because kotlinx-coroutines aren't exposed here
    }*/

    doSomething()
}