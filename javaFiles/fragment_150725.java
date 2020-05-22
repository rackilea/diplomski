bootstrap.servers=(address)
zookeeper.connect=127.0.0.1:2181
zookeeper.connection.timeout.ms=6000
sasl.jaas.config=org.apache.kafka.common.security.plain.PlainLoginModule required username="(username)" password="(password)";
security.protocol=SASL_PLAINTEXT
sasl.mechanism=PLAIN
group.id=(group)