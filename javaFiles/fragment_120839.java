#Properties
spring.cloud.stream.default.contentType=application/octet-stream
spring.cloud.stream.default.producer.headerMode=raw

//Java
byte[] payload = jacksonObjectMapper.writeValueAsBytes(entity);
return channel.send(MessageBuilder.withPayload(payload).build());