repositories {
maven {
    url 'https://nexus.hyperledger.org/content/repositories/snapshots'
}
mavenLocal()
mavenCentral()
}

dependencies {
   compile group: 'org.hyperledger.fabric', name:'fabric-chaincode-shim', version: '1.2.0-SNAPSHOT'

}