IndicesStatsResponse indicesStatsResponse = StartTCPService.getClient()
            .admin()
            .indices()
            .prepareStats(index_name)
            .all()
            .execute().actionGet();

    XContentBuilder builder = XContentFactory.jsonBuilder();
    builder.startObject();
    indicesStatsResponse.toXContent(builder, ToXContent.EMPTY_PARAMS);
    builder.endObject();
    String jsonResponse = builder.prettyPrint().string();

    JsonParser jsonParser = new JsonParser(); // from import com.google.gson.JsonParser;
    Long sizeOfIndex = jsonParser.parse(jsonResponse)
            .getAsJsonObject().get("_all")
            .getAsJsonObject().get("primaries")
            .getAsJsonObject().get("store")
            .getAsJsonObject().get("size_in_bytes").getAsLong();

    System.out.println(sizeOfIndex); // this is in Bytes