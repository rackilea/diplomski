plugins.withType<JavaPlugin> {
        extensions.configure<JavaPluginExtension> {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11

            dependencies {
                "implementation"(platform("org.springframework.boot:spring-boot-dependencies:2.2.2.RELEASE"))
            }

            tasks.withType<Test> {
                useJUnitPlatform()
            }
        }
    }