String yourData;
JsonWriter writer = new JsonWriter(response.getWriter());
    writer.beginObject();
    writer.name("data").value(yourData);
    writer.endObject();
    writer.close();