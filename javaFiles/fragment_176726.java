post(() ->
   path("updatedData", () -> {
      LOGGER.info("calling POST /updatedData");

      final ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.registerModule(new JavaTimeModule());

      return entity(Jackson.unmarshaller(objectMapper, Video.class), videoInfo -> {
          LOGGER.debug("Payload received : " + videoInfo.toString());
          ArrayList<HttpHeader> headers = getCORSHeaders();
          return respondWithHeaders(headers, () ->
                       onSuccess(videoFrameProcessing.updateVideoInfo(videoInfo), this::complete));
     });
 })),