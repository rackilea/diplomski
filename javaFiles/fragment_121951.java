<mongo:mongo-client id="mongoClient" replica-set="${mongo.replica-set}" credentials="${mongo.authenticationDB}">
            <mongo:client-options connections-per-host="${mongo.connectionsPerHost}"
                    threads-allowed-to-block-for-connection-multiplier="${mongo.threadsAllowedToBlockForConnectionMultiplier}"
                    connect-timeout="${mongo.connectTimeout}" max-wait-time="${mongo.maxWaitTime}" 
                    socket-keep-alive="${mongo.socketKeepAlive}" socket-timeout="${mongo.socketTimeout}" />
    </mongo:mongo-client>

    <mongo:db-factory dbname="${mongo.dbname}" mongo-ref="mongoClient" />

    <bean id="mongoTemplate" class="org.springframework.data.mongodb.core.MongoTemplate">
            <constructor-arg name="mongoDbFactory" ref="mongoDbFactory" />
    </bean>