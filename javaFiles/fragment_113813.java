object Path {
    def process: String => String = (input: String) => "processed"
}

scala> process("some value")
res88: String = processed

scala> process.apply("some value")
res89: String = processed