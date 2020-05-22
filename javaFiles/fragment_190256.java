AmazonSQSClientBuilder builder = AmazonSQSClientBuilder.standard();
AmazonSQS sqsClient = builder.withClientConfiguration(
    PredefinedClientConfigurations.defaultConfig()
    .withProxyHost("hostname")
    .withProxyPort(port)
    .withNonProxyHosts("no proxy hosts"))
    .build()