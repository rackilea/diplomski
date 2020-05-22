Class Foo(filename: String) {
    val index =  {
         val stream = openFile(filename)
         readLines(stream)
         ...
         someValue
     }
     println(“initialized...“) 
}