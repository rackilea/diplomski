// don't use values
for(value <- values) {
    // do something
    val v = value.toString
    // Don't save value, it will be reused. The content of value will be changed but the reference is same.
}
// don't use values