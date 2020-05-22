plugins {
    id 'org.springframework.boot' version '2.1.3.RELEASE' apply false
}

dependencyManagement {
    imports {
        mavenBom org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES
    }
}