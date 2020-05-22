try (XContentBuilder jsonBuilder = XContentFactory.jsonBuilder()) {
    BytesReference pipelineSource = jsonBuilder.startObject()
            .field("description", "Extract attachment information")
            .startArray("processors")
              .startObject()
                .startObject("foreach")
                  .field("field", "my_field")
                  .startObject("processor")
                    .startObject("attachment")
                      .field("field", "_ingest._value.my_base64_field")
                      .field("target_field", "_ingest._value.my_base64_field")
                      .field("ignore_missing", true)
                      .field("indexed_chars", -1)
                    .endObject()
                  .endObject()
                .endObject()
              .endObject()
            .endArray()
            .endObject().bytes();
    client.admin().cluster().preparePutPipeline("my_pipeline",
            pipelineSource, XContentType.JSON).get();
}