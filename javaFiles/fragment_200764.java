plugins {
    kotlin("jvm") version "1.3.61"
}

dependencies {
    api("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.61")
   // api("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.3.3") - uncomment this line to expose api. You will see kotlinx-coroutines-reactor members in intellisence
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.3.3") // mark, that this dependency is needed for compilation. However it will not be exposed to other project.
    runtimeOnly("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.3.3") // mark, that this dependency is required for runtime. It means, that it will be exposed as runtime dependency only
}