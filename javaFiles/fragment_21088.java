// from Java:
..bar(s -> { System.out.println(s); })
// however, method references might not work that easily or not without a workaround...
..bar((Consumer<String>) System.out::println); // not nice... @JvmName("kotlinsBar") to the rescue? well... that will just get more and more ugly ;-)

// from Kotlin:
..bar(Consumer(::println)) // or: ..bar(Consumer { println(it) })
..bar(::println)           // or: ..bar { println(it) } // whatever you prefer...