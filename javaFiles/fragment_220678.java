cluster = Cluster
            .builder()
            .addContactPoints("192.1.1.1","192.1.1.2")
            .withRetryPolicy(DefaultRetryPolicy.INSTANCE)
            .withLoadBalancingPolicy(
                    new TokenAwarePolicy(new DCAwareRoundRobinPolicy.Builder().build()))
            .build();