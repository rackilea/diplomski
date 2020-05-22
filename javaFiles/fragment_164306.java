path("test", () ->
  // extract the request entity, it contains the streamed entity as `getDataBytes`
  extractRequestEntity(requestEntity -> {

  // prepare what to add as suffix to the incoming entity stream:
  Source<ByteString, NotUsed> suffixSource = 
    Source.single(ByteString.fromString("\n\nADDS THIS AFTER INCOMING ENTITY"))

  // concat the suffix stream to the incoming entity stream
  Source<ByteString, Object> replySource = requestEntity.getDataBytes()
    .concat(suffixSource);

    // prepare and return the entity:
    HttpEntity.Chunked replyEntity = HttpEntities.create(ContentTypes.TEXT_PLAIN_UTF8, replySource);
    return complete(StatusCodes.OK, replyEntity);
  })
);