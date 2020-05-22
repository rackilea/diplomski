Table  table = dynamoDB.getTable("Token");
UpdateItemSpec  updateItemSpec = new UpdateItemSpec()
            .withPrimaryKey("GUID", ":guid", "#type", ":type")
            .withUpdateExpression("set #name = :val1")
            .withNameMap(new NameMap()
                    .with("#name", "last_accessed_on")
                    .with("#type", "type"))
            .withValueMap(new ValueMap()
                    .withLong(":val1", System.currentTimeMillis())
                    .withString(":guid", /* put the guid here */)
                    .withString(":type", /* put the type here */));