public MetricRecorder(String namespace, StatsDClient client) {
    Preconditions.checkNotNull(namespace);
    Preconditions.checkNotNull(client);
    this.namespace = namespace;
    this.client = client;
}