String s="{ \"children\": [ { \"children\": [ { \"name\": \"cluster\", \"children\": [ { \"name\": \"AgglomerativeCluster\", \"size\": 3938 }, { \"name\": \"TestCLuster\", \"size\": 3938 } ] } ], \"name\": \"analytics\" } ], \"name\": \"flare\"}";
ObjectMapper mapper = new ObjectMapper();
mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
Children children = mapper.readValue(s, Children.class);

System.out.println(children.getChildren());