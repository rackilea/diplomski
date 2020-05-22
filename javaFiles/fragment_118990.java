fun <T> toOptional(value : T?) : Optional<T> {
    if(value == null) {
        return Optional.empty()
    }
    return Optional.of(value)
}

val opt:Optional<String> = Optional.empty()
println(opt.map { x -> "PREFIX/$x" }.orElse(""))
val opt2:Optional<String> = Optional.of("link")
println(opt2.map { x -> "PREFIX/$x" }.orElse(""))
var str : String? = null
println(toOptional(str).map { x -> "PREFIX/$x" }.orElse(""))
var str2  = "hrefValue"
println(toOptional(str2).map { x -> "PREFIX/$x" }.orElse(""))