configurations {
    ajc
    aspects
    aspectCompile
    compile{
        extendsFrom aspects
    }
}