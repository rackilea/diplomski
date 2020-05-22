String valueData = "{\"x\":10,\"y\":10,\"z\":10}.";
valueData = valueData.replace(".", "");
valueData = valueData.replace("{", "");
valueData = valueData.replace("}", "");
valueData = valueData.replace("\"", "");
System.out.println(valueData);