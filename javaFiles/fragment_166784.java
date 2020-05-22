task foo(dependsOn: "beforeFoo") {
    println "configuring foo"
    project.ext.value = "is set by foo"
}

foo << {
    println "executing foo"
}