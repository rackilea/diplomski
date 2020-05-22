apply plugin: 'war'
apply plugin: 'ear'

dependencies {
    deploy files(war)
}