public Client getObject() throws Exception {
    this.client = nodeBuilder()
            .settings(ImmutableSettings.settingsBuilder()
                         .put("cluster.name", "shaharma")
                         .put("network.host", "127.0.0.1"))
            .client(true)
            .build()
            .start()
            .client();

    return client;
}