String json = "{\"sectors\": [{\"times\":[{\"intensity\":30," +
                "\"start\":{\"hour\":8,\"minute\":30},\"end\":{\"hour\":17,\"minute\":0}}," +
                "{\"intensity\":10,\"start\":{\"hour\":17,\"minute\":5},\"end\":{\"hour\":23,\"minute\":55}}]," +
                "\"id\":\"dbea21eb-57b5-44c9-a953-f61816fd5876\"}]}";
        String result = JsonSchemaGenerator.outputAsString("Schedule", "this is a test", json);
            /* sample output
            {
              "title": "Schedule",
              "description": "this is a test",
              "type": "object",
              "properties": {
                "sectors": {
                  "type": "array",
                  "items": {
                    "properties": {
                      "times": {
                        "type": "array",
                        "items": {
                          "properties": {
                            "intensity": {
                              "type": "number"
                            },
                            "start": {
                              "type": "object",
                              "properties": {
                                "hour": {
                                  "type": "number"
                                },
                                "minute": {
                                  "type": "number"
                                }
                              }
                            },
                            "end": {
                              "type": "object",
                              "properties": {
                                "hour": {
                                  "type": "number"
                                },
                                "minute": {
                                  "type": "number"
                                }
                              }
                            }
                          }
                        }
                      },
                      "id": {
                        "type": "string"
                      }
                    }
                  }
                }
              } 
            }
             */

        // To generate JSON schema into a file
        JsonSchemaGenerator.outputAsFile("Schedule", "this is a test", json, "output-schema.json");

        // To generate POJO(s)
        JsonSchemaGenerator.outputAsPOJO("Schedule", "this is a test", json, "com.example", "generated-sources");
    }