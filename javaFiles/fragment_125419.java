someclass {
    prefix("longPrefix") {
        val a: String = ""
    }

    fun bar() {
        println("Look at $longPrefixA")
    }
}