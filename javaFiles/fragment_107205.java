ext {
    devDependencies = ['org.foo:dep1:1.0', 'org.foo:dep2:1.0']
    prodDependencies = ['org.foo:dep3:1.0', 'org.foo:dep4:1.0']
    isProd = System.properties['env'] == 'prod'
    isDev = System.properties['env'] == 'dev'
}

apply plugin: 'java'

dependencies {
    compile 'org.foo:common:1.0'
    if (isProd) {
       compile prodDependencies
    }
    if (isDev) {
       compile devDependencies
    }
}

if (isDev) tasks.withType(War).all { it.enabled = false }