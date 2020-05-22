JsonObject clone = new JsonObject();
            clone.add(typeFieldName, new JsonPrimitive(label));
            for (Map.Entry<String, JsonElement> e : jsonObject.entrySet()) {
              clone.add(e.getKey(), e.getValue());
            }
            Streams.write(clone, out);