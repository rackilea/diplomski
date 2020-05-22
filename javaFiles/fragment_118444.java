Settings settings = Settings.builder()
                .put("cluster.name", config.db().clusterName())
                .build();

    PreBuiltTransportClient preBuiltTransportClient = new PreBuiltTransportClient(settings);
    String[] hosts = config.db().getElasticSearchHost().split(SPLIT_SEPARATOR);

    for(int i=0; i<hosts.length;i++){
        preBuiltTransportClient.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(hosts[i])
                ,config.db().getElasticSearchNodePort()));
    }

    return preBuiltTransportClient;