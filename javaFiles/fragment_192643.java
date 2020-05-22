LettuceClientConfiguration configuration = LettuceClientConfiguration.builder()
                                                    .readFrom(ReadFrom.SLAVE)
                                                    .build();

    LettuceConnectionFactory factory = new LettuceConnectionFactory(new RedisStandaloneConfiguration("x", 6379),
                                                    configuration);