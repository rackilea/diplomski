bootRun {
    String activeProfile =  System.properties['spring.profiles.active']
    String confLoc = System.properties['spring.config.location']
    systemProperty "spring.profiles.active", activeProfile
    systemProperty "spring.config.location", "file:$confLoc"
}