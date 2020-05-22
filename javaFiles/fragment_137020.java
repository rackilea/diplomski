@Query("{\n" +
        "  \"bool\": {\n" +
        "    \"must\": [\n" +
        "      {\n" +
        "        \"bool\": {\n" +
        "          \"must\": [\n" +
        "            {\n" +
        "              \"terms\": {\n" +
        "                \"aoGuid\": ?0\n" +
        "              }\n" +
        "            }\n" +
        "          ]\n" +
        "        }\n" +
        "      }\n" +
        "    ]\n" +
        "  }\n" +
        "}")
List<House> findByAoGuidIn(Collection<String> aoGuid);