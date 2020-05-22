tasks {
    val j by creating {
        doLast {
            println(System.getProperty("java.home"))
        }
    }
}