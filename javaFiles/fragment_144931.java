plugins {
    id("java-library")
    id("org.openapi.generator").version("4.0.1")
    id("org.springframework.boot").version("2.1.8.RELEASE")
}

repositories {
    jcenter()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:2.1.8.RELEASE")
    api("io.springfox:springfox-swagger2:2.8.0")
    api("io.springfox:springfox-swagger-ui:2.8.0")
    api("org.openapitools:jackson-databind-nullable:0.1.0")
}

val spec = "$rootDir/docs/openapi/api.yml"
val generatedSourcesDir = "$buildDir/generated/openapi"

openApiGenerate {
    generatorName.set("spring")

    inputSpec.set(spec)
    outputDir.set(generatedSourcesDir)

    apiPackage.set("org.openapi.example.api")
    invokerPackage.set("org.openapi.example.invoker")
    modelPackage.set("org.openapi.example.model")

    configOptions.set(mapOf(
            "dateLibrary" to "java8"
    ))
}

sourceSets {
    getByName("main") {
        java {
            srcDir("$generatedSourcesDir/src/main/java")
        }
    }
}

tasks {
    val openApiGenerate by getting

    val compileJava by getting {
        dependsOn(openApiGenerate)
    }
}