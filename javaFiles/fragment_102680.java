packagingOptions {
    exclude 'META-INF/ECLIPSE_.SF'
    exclude 'META-INF/ECLIPSE_.RSA'
}

compile("one-of-your-dependency:1.0.0"){
    exclude group: 'org.eclipse.paho'
}