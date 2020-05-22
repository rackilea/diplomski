generateGrammarSource << {
    println "Copying generated grammar lexer/parser files to main directory."
    copy {
        from "${buildDir}/generated-src/antlr/main"
        into "src/main/java"
    }
}