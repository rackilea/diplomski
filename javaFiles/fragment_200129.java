<Configuration status="warn">
   <Properties>
    <Property name="MongoDbServer">$${jndi:MongoDB.serverAddress.1.host}:$${jndi:MongoDB.serverAddress.1.port}</Property>
    <Property name="MongoDbPassword">$${jndi:MongoDB.password}</Property>
</Properties>
    <Appenders>
        <NoSql name="databaseAppender">
            <MongoDb databaseName="SISTEMA" collectionName="applicationLog"
                server="${MongoDbServer}" username="SISTEMA"
                password="${MongoDbPassword}" />
        </NoSql>
    ....