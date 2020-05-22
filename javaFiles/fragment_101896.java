apply plugin: 'java'
apply plugin: 'pmd'

pmd {
    ruleSets = [
            "basic",
            "braces",
            "naming",
            "android",
            "clone",
            "codesize",
            "controversial",
            "design", 
            "finalizers",
            "imports",
            "j2ee",
            "javabeans",
            "junit",
            "logging-jakarta-commons",
            "logging-java",
            "migrating",
            "optimizations",
            "strictexception",
            "strings",
            "sunsecure",
            "typeresolution",
            "unusedcode"
            ]
}
repositories {
    mavenCentral()
}